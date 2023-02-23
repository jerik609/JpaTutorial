package com.jerikthedog.SpringDataJpaTutorial.objectProxyExample;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

// indeed, transaction is not created for internal method call, despite being annotated with @Transactional

@Service
public class TestService {

    @Transactional
    public void invoice() {
        System.out.println("invoice");
        createPdf();
    }

    @Transactional(value = Transactional.TxType.REQUIRES_NEW)
    public void createPdf() {
        System.out.println("createPdf");
    }
}
