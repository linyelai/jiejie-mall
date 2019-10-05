package com.jiejie.mall.member.mapper;

import com.jiejie.mall.member.model.MemberAllInfo;
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
    public MemberAllInfo findMemberByName(@Param(value = "memberName") String memberName);

    /**
     * 更新会员
     * @param memberInfo
     * @return
     */
    public int updateMember(MemberAllInfo memberInfo);

    /**
     * 根据会员id删除会员
     * @param id
     * @return
     */
    public int deleteMember(Integer id);

    /**
     * 根据id查询会员信息
     * @param id
     * @return
     */
    public MemberAllInfo findMemberById(@Param(value = "id")Integer id);

}
