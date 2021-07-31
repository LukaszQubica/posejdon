package com.lucqubica.module.blog;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@Scope("singleton")
public class PostMemoryStorageService {
    private static final List<PostDto> STORAGE = new ArrayList<>();
    static {
        STORAGE.add(new PostDto( "Lorem ipsum dolor 1", "What is Lorem Ipsum?\n" +
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."));
        STORAGE.add(new PostDto( "Lorem ipsum dolor 2", "Lorem ..."));
        STORAGE.add(new PostDto( "Lorem ipsum dolor 3 ", "Lorem Ipsum is simply dummy text"));
        STORAGE.add(new PostDto( "Lorem ipsum dolor 4", "Lorem ..."));
    }
    public Optional<PostDto> getPost(String uuid) {
        return STORAGE
                .stream()
                .filter(post -> post.getUuid().equalsIgnoreCase(uuid)).findFirst();
    }
    public List<PostDto> getPosts() {
        return STORAGE;
    }
    public PostDto create(String title, String text) {
        PostDto post = new PostDto(title, text);
        STORAGE.add(post);
        return post;
    }
}