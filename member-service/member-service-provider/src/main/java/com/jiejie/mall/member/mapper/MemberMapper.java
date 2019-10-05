package com.jiejie.mall.member.mapper;

import com.jiejie.mall.member.model.MemberInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    /**
     *  新增会员
     * @param memberInfo
     * @return
     */
    public int addMember(MemberInfo memberInfo);

    /**
     * 根据会员名查找会员信息
     * @return
     */
    public MemberInfo findMemberByName();

    /**
     * 更新会员
     * @param memberInfo
     * @return
     */
    public int updateMember(MemberInfo memberInfo);

    /**
     * 根据会员id删除会员
     * @param id
     * @return
     */
    public int deleteMember(Integer id);

}
