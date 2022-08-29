package se.lexicon.rajashree.booklender.model.Implementaion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.rajashree.booklender.dto.BookDto;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.dto.LoanDto;
import se.lexicon.rajashree.booklender.model.Book;
import se.lexicon.rajashree.booklender.model.LibraryUser;
import se.lexicon.rajashree.booklender.model.Loan;
import se.lexicon.rajashree.booklender.repositories.LibraryUserRepository;
import se.lexicon.rajashree.booklender.repositories.LoanRepository;
import se.lexicon.rajashree.booklender.service.LoanService;

import java.util.ArrayList;
import java.util.Iterator;
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
    public List<LoanDto> findByBookId(int bookId){


        LoanDto convertedToDto = null;
        ArrayList<LoanDto> listOfLoanDto = new ArrayList();
        Iterator<Loan> loanIterator=loanRepository.findByBookId(bookId).iterator();
        if(loanIterator != null){
            if(loanIterator.hasNext()){
                Loan loan = loanIterator.next();
                convertedToDto = modelMapper.map(loan, LoanDto.class);
                listOfLoanDto.add(convertedToDto);
            }
        }
        return listOfLoanDto;

    }

    @Override
    public List<LoanDto> findByUserId(int userId){
        LoanDto convertedToDto = null;
        ArrayList<LoanDto> listOfLoanDto = new ArrayList();
        if (userId==0) throw new IllegalArgumentException("loanId was Zero");
        Iterator<Loan> loanIterator=loanRepository.findByBookId(userId).iterator();
        if(loanIterator != null){
            if(loanIterator.hasNext()){
                Loan loan = loanIterator.next();
                convertedToDto = modelMapper.map(loan, LoanDto.class);
                listOfLoanDto.add(convertedToDto);
            }
        }

        return listOfLoanDto;
    }

    @Override
    public List<LoanDto> findByTerminated() {




        return null;
    }

    @Override
    public List<LoanDto> findAll() {
        LoanDto convertedToDto = null;
        ArrayList<LoanDto> listloanDto = new ArrayList();

        Iterator<Loan> loanIterator=loanRepository.findAll().iterator();
        if(loanIterator != null){
            if(loanIterator.hasNext()){
             Loan loan = loanIterator.next();
                convertedToDto = modelMapper.map(loan, LoanDto.class);
                listloanDto.add(convertedToDto);
            }
        }
        return listloanDto;
    }
    @Override
    public LoanDto create(LoanDto loanDto) {
        LoanDto convertedToDto = null;

        try {
            if (loanDto == null) throw new IllegalArgumentException("loanDto was null");
            if (loanDto.getLoanId() == 0) throw new IllegalArgumentException("loanDto.Id must be null");

           Loan convertedToEntity = modelMapper.map(loanDto, Loan.class);
           Loan createdLoan = loanRepository.save(convertedToEntity);
            convertedToDto = modelMapper.map(createdLoan, LoanDto.class);

        } catch (Exception e) {

        }
        return convertedToDto;
    }

    @Override
    public LoanDto update(LoanDto loanDto) {
    LoanDto convertedToDto=null;
    if (loanDto==null) throw new IllegalArgumentException("loanDto was null");
    if (loanDto.getLoanId()==0)throw  new IllegalArgumentException("loanDtoId must be null");
        Loan convertedToEntity = modelMapper.map(loanDto, Loan.class);
        Loan updateLoan = loanRepository.save(convertedToEntity);

        convertedToDto = modelMapper.map(updateLoan, LoanDto.class);
        return convertedToDto;

    }
    @Override
    public boolean delete(long loanId) {

        if (loanId==0) throw new IllegalArgumentException("userId was Zero");
        loanRepository.deleteById(Long.valueOf(loanId).intValue());
        return true;





    }
}
