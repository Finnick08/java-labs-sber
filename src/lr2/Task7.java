package lr2;

// Интерфейс
interface BankAccountInterface {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

// Класс банковского счёта
class BankAccount implements BankAccountInterface {
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Пополнение на " + amount + ". Баланс: " + balance);
        } else {
            System.out.println("Сумма пополнения должна быть положительной.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Недостаточно средств.");
        } else if (amount <= 0) {
            System.out.println("Сумма снятия должна быть положительной.");
        } else {
            balance -= amount;
            System.out.println("Снятие " + amount + ". Баланс: " + balance);
        }
    }

    @Override
    public double getBalance() { return balance; }

    @Override
    public String toString() {
        return "BankAccount{owner='" + owner + "', balance=" + balance + "}";
    }
}

public class Task7 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Иван", 1000.0);
        System.out.println(account);
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000);
        System.out.println("Итоговый баланс: " + account.getBalance());
    }
}