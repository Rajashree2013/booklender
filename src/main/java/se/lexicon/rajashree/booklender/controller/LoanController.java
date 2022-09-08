package se.lexicon.rajashree.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import se.lexicon.rajashree.booklender.dto.LibraryUserDto;
import se.lexicon.rajashree.booklender.dto.LoanDto;
import se.lexicon.rajashree.booklender.exception.ObjectDuplicateException;
import se.lexicon.rajashree.booklender.exception.ObjectNotFoundException;

import se.lexicon.rajashree.booklender.service.LoanService;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1/Loan")
@Validated
public class LoanController {
LoanService loanService;
@Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    @GetMapping("/{id}") // find by id
    public ResponseEntity<LoanDto> findById(@PathVariable("id") @Min(0) @Max(100000) Integer loanId) throws ObjectNotFoundException {
        LoanDto loanDto = loanService.findById(loanId);
        return ResponseEntity.ok().body(loanDto);
    }

    @PostMapping("/")
    public ResponseEntity<LoanDto> createdloan(@RequestBody @Valid LoanDto loanDto) throws ObjectDuplicateException {
        System.out.println("libUserDto = " + loanDto);
        LoanDto createdloan= loanService.create(loanDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdloan); // 201
    }


    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody @Valid LoanDto loanDto) {
        System.out.println("roleDto = " + loanDto);
        loanService.update(loanDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
    }









}
