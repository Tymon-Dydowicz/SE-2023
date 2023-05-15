package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void CalculateTotal(){
        ExpenseRepository expenseRepository = mock(ExpenseRepository.class);
        ArrayList<Expense> expenses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Expense expense = new Expense();
            expense.setAmount((i+1)*10);
            expenses.add(expense);
        }

        when(expenseRepository.getExpenses()).thenReturn(expenses);
        FancyService fancyService = mock(FancyService.class);
        ExpenseManager expenseManager = new ExpenseManager(expenseRepository, fancyService);

        assertEquals(60, expenseManager.calculateTotal());
    }

    @Test
    void CalculateTotalForCategory(){
        ExpenseRepository expenseRepository = mock(ExpenseRepository.class);
        ArrayList<Expense> expenses = new ArrayList<>();
        Expense expense1 = new Expense();
        expense1.setCategory("Home");
        expense1.setAmount(20);

        Expense expense2 = new Expense();
        expense2.setCategory("Home");
        expense2.setAmount(30);

        Expense expense3 = new Expense();
        expense3.setCategory("Car");
        expense3.setAmount(40);

        Expense expense4 = new Expense();
        expense4.setCategory("Car");
        expense4.setAmount(50);

        expenses.add(expense1);
        expenses.add(expense2);
        expenses.add(expense3);
        expenses.add(expense4);

        when(expenseRepository.getExpensesByCategory("Food")).thenReturn(Collections.emptyList());
        when(expenseRepository.getExpensesByCategory("Home")).thenReturn(List.of(expense1, expense2));
        when(expenseRepository.getExpensesByCategory("Car")).thenReturn(List.of(expense3, expense4));
        when(expenseRepository.getExpensesByCategory("Sport")).thenReturn(Collections.emptyList());
        when(expenseRepository.getExpenses()).thenReturn(expenses);

        FancyService fancyService = mock(FancyService.class);
        ExpenseManager expenseManager = new ExpenseManager(expenseRepository, fancyService);

        assertEquals(50, expenseManager.calculateTotalForCategory("Home"));
        assertEquals(90, expenseManager.calculateTotalForCategory("Car"));
        assertEquals(0, expenseManager.calculateTotalForCategory("Sport"));
        assertEquals(0, expenseManager.calculateTotalForCategory("Food"));
    }

    @Test
    void CalculateTotalInDollars() throws ConnectException {
        ExpenseRepository expenseRepository = mock(ExpenseRepository.class);
        FancyService fancyService = mock(FancyService.class );
        when(fancyService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer(
                invocation -> (double)invocation.getArgument(0)*4.0
        );

        ArrayList<Expense> expenses = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Expense expense = new Expense();
            expense.setAmount((i+1)*10);
            expenses.add(expense);
        }
        when(expenseRepository.getExpenses()).thenReturn(expenses);


        ExpenseManager expenseManager = new ExpenseManager(expenseRepository, fancyService);
        expenseManager.calculateTotalInDollars();
        assertEquals(240, expenseManager.calculateTotalInDollars());
    }

    @Test
    void ThrowingCalculateTotalInDollars() throws ConnectException {
        ExpenseRepository expenseRepository = mock(ExpenseRepository.class);
        FancyService fancyService = mock(FancyService.class );
        when(fancyService.convert(anyDouble(), eq("PLN"), eq("USD"))).thenThrow(ConnectException.class);
        ExpenseManager expenseManager = new ExpenseManager(expenseRepository, fancyService);
        assertEquals(-1, expenseManager.calculateTotalInDollars());
    }
}
