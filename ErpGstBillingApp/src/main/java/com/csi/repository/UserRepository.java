package com.csi.repository;

import com.csi.enitity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Long> {
    UserData findByUserName(String userName);

}
