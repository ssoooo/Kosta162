package GeneralAffairs.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import GeneralAffairs.domain.Member;

public interface MemberMapper {
	void registMember(Member member);
	int updateMember(Member member);
	void deleteMember(String memberId);
	Member retrieveMemberById(String memberId);
	List<Member> retrieveAllMembersByGroup(int groupId);
	List<Member> retrieveMembersByEvent(int eventId);
	int updateGrade(@Param("memberId") String memberId,@Param("groupId") int groupId);
	List<Member> retrieveAllSignInGroupReq(int groupId);
	void registReqSignInMember(@Param("memberId") String memberId,@Param("groupId") int groupId);
	void deleteSignInGroupReq(@Param("memberId") String memberId,@Param("groupId") int groupId);
	int checkMemberHasGroup(String memberId);

}
