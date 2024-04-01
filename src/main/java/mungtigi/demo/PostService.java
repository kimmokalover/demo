package mungtigi.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Long countAllPosts() {
        return postRepository.count();
    }

    public List<Post> findPostsByPage(int page, int pageSize) {
        return postRepository.findAll(PageRequest.of(page - 1, pageSize)).getContent();
    }

    public void saveData(Post post){
        postRepository.save(post);
    }

    public void delete(Long id){
        postRepository.deleteById(id);
    }

    public Post getPost(Long id){
        return postRepository.findById(id).get();
    }


}