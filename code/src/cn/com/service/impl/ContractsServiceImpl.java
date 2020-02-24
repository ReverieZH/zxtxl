package cn.com.service.impl;

import cn.com.mapper.ContractsMapper;
import cn.com.pojo.Contracts;
import cn.com.pojo.User;
import cn.com.service.ContractsService;
import cn.com.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ContractsServiceImpl implements ContractsService {
    @Autowired(required = false)
    private ContractsMapper contractsMapper;

    @Override
    public void addContracts(Contracts contracts) throws Exception {
        try {
            String cid=null;
            String maxcid=contractsMapper.selectMaxCidByUsername(contracts.getUsername());
            System.out.println(maxcid);
            if(maxcid!=null){
                int maxindex=Integer.valueOf(maxcid.substring(maxcid.length()-3))+1;
                cid=contracts.getUsername()+ Common.addZeroToString(String.valueOf(maxindex),3);
            }else{
                cid=contracts.getUsername()+"001";
            }
            contracts.setCid(cid);
            contractsMapper.addContracts(contracts);
        } catch (Exception e) {
            System.out.println("addContracts事务回滚");
            throw new RuntimeException("addContracts事务回滚");
        }
    }

    @Override
    public void updateContracts(Contracts contracts) {
        try {
            contractsMapper.updateContracts(contracts);
        } catch (Exception e) {
            System.out.println("updateContracts事务回滚");
            throw new RuntimeException("updateContracts事务回滚");
        }
    }

    @Override
    public void deleteContracts(String cid) {
        try {
            contractsMapper.deleteContracts(cid);
        } catch (Exception e) {
            System.out.println("deleteContracts事务回滚");
            throw new RuntimeException("deleteContracts事务回滚");
        }

    }

    @Override
    public void deleteContracts(List<String> cidList) {
        try {
            contractsMapper.deleteContractsList(cidList);
        } catch (Exception e) {
            System.out.println("deleteContractsList事务回滚");
            throw new RuntimeException("deleteContractsList事务回滚");
        }
    }

    @Override
    public Contracts getContractsById(String cid) {
        Contracts contract=contractsMapper.getContractsById(cid);
        return contract;
    }

    @Override
    public List<Contracts> getContractsList(String username, String name, String number, String phone, String wrokspace, String role) {
        List<Contracts> contractsList=contractsMapper.getContractsList(username,name,number,phone,wrokspace,role);
        return contractsList;
    }
}
