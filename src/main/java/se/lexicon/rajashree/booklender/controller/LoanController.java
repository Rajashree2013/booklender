package se.lexicon.rajashree.booklender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/Loan")
@Validated
public class LoanController {

    LoanController loanController ;

@Autowired

    public LoanController(LoanController loanController) {
        this.loanController = loanController;
    }
}
