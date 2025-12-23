package com.back.service;

import com.back.entity.Member;
import com.back.entity.Post;
import com.back.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(int postId) {
        return postRepository.findById(postId);
    }

    public Post write(Member author, String title, String content) {
        author.increaseActivityScore(3);

        return postRepository.save(new Post(author, title, content));
    }
}
