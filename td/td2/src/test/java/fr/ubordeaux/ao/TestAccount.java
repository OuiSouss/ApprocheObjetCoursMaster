package fr.ubordeaux.ao;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.UUID;

public class TestAccount {
    private final UUID _uuid = UUID.randomUUID();
    
    @Test
    public void TestAccountBalance() {
	Account account = new Account(_uuid, "Account");
	Transaction transaction = new Transaction("Trans", 1000);
    }
}
