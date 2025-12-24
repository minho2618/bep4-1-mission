package com.back.boundedContext.post.app;

import com.back.boundedContext.member.domain.Member;
import com.back.boundedContext.post.domain.Post;
import com.back.boundedContext.post.domain.PostMember;
import com.back.boundedContext.post.out.PostRepository;
import com.back.global.rsData.RsData;
import com.back.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;
    private final PostJoinUseCase postJoinUseCase;

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(int postId) {
        return postRepository.findById(postId);
    }

    public RsData<Post> write(Member author, String title, String content) {
        return postJoinUseCase.write(author, title, content);
    }

    public PostMember syncMember(MemberDto member) {
        PostMember postMember = new PostMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                "",
                member.getNickname()
        );

        return postMember;
    }
}
