package se.lexicon.rajashree.booklender.model.Implementaion;

import org.apache.tomcat.jni.Library;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.repositories.BookRepository;
import se.lexicon.rajashree.booklender.repositories.LibraryUserRepository;
import se.lexicon.rajashree.booklender.service.LibraryUserService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class LibraryUserServiceImpl implements LibraryUserService {

    LibraryUserRepository libraryUserRepository;
    ModelMapper modelMapper;
    @Autowired
    public LibraryUserServiceImpl(LibraryUserRepository libraryUserRepository, ModelMapper modelMapper) {
        this.libraryUserRepository = libraryUserRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public LibraryUserDto findById(int userId) {
        LibraryUserDto convertedToDto = null;
        if (userId==0) throw new IllegalArgumentException("userId was Zero");
        Optional<LibraryUser> libraryUser = libraryUserRepository.findById(userId);
        convertedToDto = modelMapper.map(libraryUser, LibraryUserDto.class);

        return convertedToDto;

    }

    @Override
    public LibraryUserDto findByEmail(String email) {
        LibraryUserDto convertedToDto = null;
        if (email==null) throw new IllegalArgumentException("email was null");
        Optional<LibraryUser> libraryUser = libraryUserRepository.findByEmail(email);
        convertedToDto = modelMapper.map(libraryUser, LibraryUserDto.class);
        return convertedToDto;
    }

    @Override
    public List<LibraryUserDto> findByAll() {

        LibraryUserDto convertedToDto = null;
        ArrayList<LibraryUserDto> listLibUserDto = new ArrayList();

        Iterator<LibraryUser> libUserIterator=libraryUserRepository.findAll().iterator();
        if(libUserIterator != null){
            if(libUserIterator.hasNext()){
                LibraryUser libraryUser = libUserIterator.next();
                convertedToDto = modelMapper.map(libraryUser, LibraryUserDto.class);
                listLibUserDto.add(convertedToDto);
            }
        }
        return listLibUserDto;
    }

    @Override
    public LibraryUserDto create(LibraryUserDto libraryUserDto) {

        LibraryUserDto convertedToDto = null;

        try {
            if (libraryUserDto == null) throw new IllegalArgumentException("libraryUserDto was null");
            if (libraryUserDto.getUserId() == 0) throw new IllegalArgumentException("BookDto.Id must be null");

            LibraryUser convertedToEntity = modelMapper.map(libraryUserDto, LibraryUser.class);
            LibraryUser createdLibraryUser = libraryUserRepository.save(convertedToEntity);
            convertedToDto = modelMapper.map(createdLibraryUser, LibraryUserDto.class);

        } catch (Exception e) {

        }
        return convertedToDto;
    }

    @Override
    public LibraryUserDto update(LibraryUserDto libraryUserDto) {

        LibraryUserDto convertedToDto = null;
        if (libraryUserDto==null)throw new IllegalArgumentException("bookDto was null");
        if (libraryUserDto.getUserId()==0) throw new IllegalArgumentException("bookDto.Id must not be null");
        LibraryUser convertedToEntity  = modelMapper.map(libraryUserDto, LibraryUser.class);
        LibraryUser createdLibraryUser= libraryUserRepository.save( convertedToEntity);
        convertedToDto = modelMapper.map(createdLibraryUser, LibraryUserDto.class);
        return convertedToDto;

    }

    @Override
    public boolean delete(int userId)
    {
        if (userId==0) throw new IllegalArgumentException("userId was Zero");
        libraryUserRepository.deleteById(userId);
        return true;
    }
}



