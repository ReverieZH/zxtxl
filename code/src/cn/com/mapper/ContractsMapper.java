package cn.com.mapper;

import cn.com.pojo.Contracts;
import cn.com.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContractsMapper {
        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public String selectMaxCidByUsername(@Param("username") String username);

        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public int addContracts(Contracts contracts);

        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public int updateContracts(Contracts contracts);

        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public int deleteContracts(String cid);

        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public int deleteContractsList(List<String> cidList);

        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public Contracts getContractsById(String cid);


        /**
        * @Description:
        * @Date:
        * @Author:
        */
        public List<Contracts> getContractsList(@Param("username") String username,@Param("name") String name, @Param("number") String number, @Param("phone") String phone, @Param("workspace") String workspace, @Param("role") String role);
}
