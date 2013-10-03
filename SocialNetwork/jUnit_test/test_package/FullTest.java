package test_package;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestLogin.class,
	TestNewPassword.class,
	TestAuthor.class,
	TestSistema.class
})
public class FullTest {
}