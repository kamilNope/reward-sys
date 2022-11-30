package com.edge1.kamil.nope.rewardsys.controller;

import com.edge1.kamil.nope.rewardsys.model.Customer;
import com.edge1.kamil.nope.rewardsys.model.Transaction;
import com.edge1.kamil.nope.rewardsys.repository.CustomerRepository;
import com.edge1.kamil.nope.rewardsys.repository.TransactionRepository;
import com.edge1.kamil.nope.rewardsys.service.RewardService;
import com.edge1.kamil.nope.rewardsys.view.TransactionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    @Mock
    TransactionRepository transactionRepository;
    @Mock
    CustomerRepository customerRepository;

    @Spy
    RewardService rewardService;

    @InjectMocks
    TransactionController transactionController;

    @Test
    void shouldAddTransaction() {
        // given
        TransactionDTO transactionDTO = new TransactionDTO(100L, 110d, 0,1L);
        Transaction transaction = new Transaction(
                100L, 1000d, new Date(2021, 9, 1),0,
                new Customer(1L, "TED"));
        final Customer ted = new Customer(1L, "TED");
        ReflectionTestUtils.setField(rewardService, "doublePointsThreshold", 100);
        ReflectionTestUtils.setField(rewardService, "singlePointsThreshold", 50);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(ted));
        when(transactionRepository.save(any())).thenReturn(transaction);

        // when
        final ResponseEntity<TransactionDTO> transactionOfCustomer =
                transactionController.addNewTransactionOfCustomer(transactionDTO);
        // then
        verify(customerRepository, times(1)).findById(1L);
        verify(transactionRepository, times(1)).save(any());
        assertEquals(HttpStatus.CREATED, transactionOfCustomer.getStatusCode());
        assertEquals(110d, transactionOfCustomer.getBody().getPrice());
        assertEquals(70, transactionOfCustomer.getBody().getRewardPoints());
    }

    @Test
    void shouldUpdateTransaction() {
        // given
        TransactionDTO transactionDTO = new TransactionDTO(100L, 120d, 0,1L);
        final Customer ted = new Customer(1L, "TED");
        ReflectionTestUtils.setField(rewardService, "doublePointsThreshold", 100);
        ReflectionTestUtils.setField(rewardService, "singlePointsThreshold", 50);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(ted));
        // when
        final ResponseEntity<TransactionDTO> transactionOfCustomer = transactionController
                .updateTransactionOfCustomer(transactionDTO);
        // then
        verify(customerRepository, times(1)).findById(1L);
        verify(transactionRepository, times(1)).save(any());
        assertEquals(HttpStatus.OK, transactionOfCustomer.getStatusCode());
        assertEquals(transactionDTO, transactionOfCustomer.getBody());
        assertEquals(120d, transactionOfCustomer.getBody().getPrice());
        assertEquals(90, transactionOfCustomer.getBody().getRewardPoints());
    }
}