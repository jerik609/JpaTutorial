package com.jerikthedog.SpringDataJpaTutorial.test;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

@Service
public class TestService {

    @Transactional
    public void invoice() {
        createPdf();
        // send invoice as email, etc.
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void createPdf() {
        // ...
    }
}
