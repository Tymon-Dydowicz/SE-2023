package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        IFancyDatabase myDatabase = mock(IFancyDatabase.class);
        when(myDatabase.queryAll()).thenReturn(Collections.emptyList());
        InOrder inOrder = inOrder(myDatabase);

        ExpenseRepository expenseRepository = new ExpenseRepository(myDatabase);
        expenseRepository.loadExpenses();

        inOrder.verify(myDatabase).connect();
        inOrder.verify(myDatabase).queryAll();
        inOrder.verify(myDatabase).close();

        assertEquals(Collections.emptyList(), expenseRepository.getExpenses());

    }

    @Test
    void saveExpenses() {
        IFancyDatabase myDatabase = mock(IFancyDatabase.class);

        ExpenseRepository expenseRepository = new ExpenseRepository(myDatabase);
        for (int i = 0; i < 5; i++) {
            Expense expense = new Expense();
            expenseRepository.addExpense(expense);
        }
        expenseRepository.saveExpenses();


        verify(myDatabase, times(5)).persist(any(Expense.class));
    }
}
