package com.hzitxx.hitao.pojo;

import com.hzitxx.hitao.entity.ShopMember;
import lombok.Data;

@Data
public class MemberInfo {
    private String token;
    private ShopMember shopMember;
    public MemberInfo(){

    }
    public MemberInfo(String token, ShopMember shopMember) {
        this.token = token;
        this.shopMember = shopMember;
    }
}
