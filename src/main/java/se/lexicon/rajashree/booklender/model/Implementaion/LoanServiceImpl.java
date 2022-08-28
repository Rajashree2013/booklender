package se.lexicon.rajashree.booklender.model.Implementaion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.dto.LoanDto;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.model.Loan;
import se.lexicon.rajashree.booklender.repositories.LibraryUserRepository;
import se.lexicon.rajashree.booklender.repositories.LoanRepository;
import se.lexicon.rajashree.booklender.service.LoanService;

import java.util.List;
import java.util.Optional;

public class LoanServiceImpl implements LoanService {

    LoanRepository loanRepository;
    ModelMapper modelMapper;
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, ModelMapper modelMapper) {
        this.loanRepository = loanRepository;
        this.modelMapper = modelMapper;
    }

        @Override
    public LoanDto findById(long loanId){
            LoanDto convertedToDto = null;
            if (loanId==0) throw new IllegalArgumentException("loanId was Zero");
            Optional<Loan> loan = loanRepository.findById(Long.valueOf(loanId).intValue());
            convertedToDto = modelMapper.map(loan ,LoanDto.class);
            return convertedToDto;
        }

    @Override
    public List<LoanDto> findByBookId(String bookId)



    {
        return null;
    }

    @Override
    public List<LoanDto> findByUserId(String userId)


    {


        return null;
    }

    @Override
    public List<LoanDto> findByTerminated() {
        return null;
    }

    @Override
    public List<LoanDto> findAll() {
        return null;
    }

    @Override
    public LoanDto create(LoanDto loanDto) {
        LoanDto convertedToDto = null;

        try {
            if (loanDto == null) throw new IllegalArgumentException("loanDto was null");
            if (loanDto.getLoanId() == 0) throw new IllegalArgumentException("BookDto.Id must be null");

           Loan convertedToEntity = modelMapper.map(loanDto, Loan.class);
           Loan createdLoan = loanRepository.save(convertedToEntity);
            convertedToDto = modelMapper.map(createdLoan, LoanDto.class);

        } catch (Exception e) {

        }
        return convertedToDto;


    }

    @Override
    public LoanDto update(LoanDto loanDto) {
        return null;
    }

    @Override
    public boolean delete(long loanId) {
        return false;
    }
}
