package se.lexicon.rajashree.booklender.model.Implementaion;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.Loan;
import se.lexicon.rajashree.booklender.repositories.BookRepository;
import se.lexicon.rajashree.booklender.service.BookService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    ModelMapper modelMapper;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


   @Override
    public BookDto create(BookDto bookDto) {
       BookDto convertedToDto = null;

       try {
           if (bookDto == null) throw new IllegalArgumentException("BookDto was null");
           if (bookDto.getBookId() == 0) throw new IllegalArgumentException("BookDto.Id must be null");

           Book convertedToEntity = modelMapper.map(bookDto, Book.class);
           Book createdBook = bookRepository.save(convertedToEntity);
           convertedToDto = modelMapper.map(createdBook, BookDto.class);

       } catch (Exception e) {

       }
       return convertedToDto;
   }



    @Override
    public List<BookDto> findByReserved(boolean reserved) {

        ArrayList<BookDto> listOfBookDto = new ArrayList();
        List listBook = new ArrayList();
        Book book = null;
        BookDto convertedToDto = null;


        if(reserved){
            listBook = bookRepository.findByReserved(reserved);
            if(listBook != null && listBook.size() > 0){
                Iterator<Book> itr = listBook.iterator();
                while (itr.hasNext()){
                    book = itr.next();
                    convertedToDto = modelMapper.map(book, BookDto.class);
                    listOfBookDto.add(convertedToDto);
                }

            }
        }


         return listOfBookDto;
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {

        ArrayList<BookDto> listOfBookDto = new ArrayList();
        List listBook = new ArrayList();
        Book book = null;
        BookDto convertedToDto = null;


        if(available){
            listBook = bookRepository.findByAvailable(available);
            if(listBook != null && listBook.size() > 0){
                Iterator<Book> itr = listBook.iterator();
                while (itr.hasNext()){
                    book = itr.next();
                    convertedToDto = modelMapper.map(book, BookDto.class);
                    listOfBookDto.add(convertedToDto);
                }

            }
        }



        return listOfBookDto;
    }

    @Override
    public List<BookDto> findBytitle(String title) {

        // Variable declaration and intilize variable
        ArrayList<BookDto> listOfBookDto = new ArrayList();
        List listBook = new ArrayList();
        Book book = null;
        BookDto convertedToDto = null;


        if (title == null) throw new IllegalArgumentException("title was null");
            if(title != null){
                listBook = bookRepository.findByTitle(title);
                    if(listBook != null && listBook.size() > 0){
                        Iterator<Book> itr = listBook.iterator();
                            while (itr.hasNext()){
                                book = itr.next();
                                convertedToDto = modelMapper.map(book, BookDto.class);
                                listOfBookDto.add(convertedToDto);
                            }

                    }
            }
        return listOfBookDto;
    }

    @Override
    public BookDto findById(int bookId)
    {
        BookDto convertedToDto = null;
        if (bookId==0) throw new IllegalArgumentException("bookId was Zero");
        Optional<Book> book = bookRepository.findById(bookId);
        convertedToDto = modelMapper.map(book, BookDto.class);

        return convertedToDto;
    }

    @Override
    public List<BookDto> findByall() {
        BookDto convertedToDto = null;
        ArrayList<BookDto> listOfBookDto = new ArrayList();
        Iterator<Book> bookIterator=bookRepository.findAll().iterator();
        if(bookIterator != null){
            if(bookIterator.hasNext()){
                Book book = bookIterator.next();
                convertedToDto = modelMapper.map(book, BookDto.class);
                listOfBookDto.add(convertedToDto);
            }
        }
        return listOfBookDto;
    }


    @Override
    public BookDto Update(BookDto bookDto) {
        BookDto convertedToDto = null;
    if (bookDto==null)throw new IllegalArgumentException("bookDto was null");
        if (bookDto.getBookId() == 0) throw new IllegalArgumentException("bookDto.Id must not be null");
            Book convertedToEntity  = modelMapper.map(bookDto, Book.class);
            Book createdBook = bookRepository.save( convertedToEntity);
            convertedToDto = modelMapper.map(createdBook, BookDto.class);
            return convertedToDto;
    }

    @Override
    public boolean delete(int bookId) {
       if  (bookId==0) throw new IllegalArgumentException("bookId was Zero");
        findById(bookId);
        bookRepository.deleteById(bookId);
        return false;
    }
}
