package com.example.marketplace.repository;

import com.example.marketplace.domain.Like;
import com.example.marketplace.domain.Products;
import com.example.marketplace.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface LikeRepository extends JpaRepository<Like, Long> {


    @Modifying
    @Query("update rating  r SET r.isLiked = false where  r.prodId.id =:prodId and  r.userId.id = :userId")
    void dislikeProduct(@Param("prodId") Long prodId, Long userId);

    Optional<Like> findByUserIdAndProdId(User user, Products products);

    @Modifying
    @Query("update rating  r SET r.isLiked = true where r.prodId.id = :prodId and r.userId.id = :userId")
    void likeProduct(@Param("prodId") Long prodId, Long userId);



}