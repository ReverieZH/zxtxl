package cn.com.service;

import cn.com.pojo.Contracts;

import java.util.List;

public interface ContractsService {
    public void addContracts(Contracts contracts) throws Exception;

    public void updateContracts(Contracts contracts);

    public void deleteContracts(String cid);

    public void deleteContracts(List<String> cidList);

    public Contracts getContractsById(String cid);

    public List<Contracts> getContractsList(String username, String name, String number, String phone, String wrokspace, String role);
}
