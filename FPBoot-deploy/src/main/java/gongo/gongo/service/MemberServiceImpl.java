package gongo.gongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gongo.gongo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private final MemberRepository mRepo;

    public Long getWishlistId(String memberId) throws Exception {

        return mRepo.findWishlistIdByMemberId(memberId);

    }

}
