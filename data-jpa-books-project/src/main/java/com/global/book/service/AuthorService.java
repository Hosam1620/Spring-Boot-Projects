package com.global.book.service;

import com.global.book.base.BaseRepository;
import com.global.book.base.BaseService;
import com.global.book.entity.Author;
import com.global.book.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService extends BaseService<Author, Long> {
   @Autowired
    public AuthorService(BaseRepository<Author, Long> baseRepository, AuthorRepo authorRepo) {
        super(baseRepository);
        this.authorRepo = authorRepo;
    }

    private final AuthorRepo authorRepo;

    //
//    @Autowired
//    public AuthorService(AuthorRepo authorRepo) {
//        this.authorRepo = authorRepo;
//    }
//
//    public Author findById(Long id) {
//        /*note that if you make find by id just without orElseThrow()
//         will give and error because this is maybe cause an exception
//         if it returns null
//        */
//        return authorRepo.findById(id).orElseThrow();
//    }
//
//    public Iterable<Author> findAll() {
//        return authorRepo.findAll();
//    }
//
//    public Author insert(Author author) {
//        //because I make it Generated as identity
//        if(author.getId()!=null){
//            throw new RuntimeException("ID Should be null");
//        }
//        return authorRepo.save(author);
//    }
//    public Author getReferenceById(Long id){
//        //getOne() is deprecated with findById()and also this is deprecated with getReferenceById() method ;
//        return authorRepo.getReferenceById(id);
//    }
//    public List<Author> insertAll(List<Author> authors){
//        //jpa provide save all to same more than one record at the same time
//        return authorRepo.saveAll(authors);
//    }
//    //here we need to update the name only so we make that.
    @Override
    public Author updateName(Author author) {
        Author authorFromDB = findById(author.getId());
        authorFromDB.setName(author.getName());
        return authorRepo.save(authorFromDB);
    }
//
//    public void delete(Long id) {
//        authorRepo.deleteById(id);
//    }

}
