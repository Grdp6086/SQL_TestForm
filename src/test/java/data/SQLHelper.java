package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {

    private static final QueryRunner queryRunner = new QueryRunner();

    private SQLHelper(){}

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app","pass");
    }

    @SneakyThrows
    public static DataHelper.VerificationCode getVerificationCode(){
        var scl = "SELECT code FROM auth_codes ORDER BY created DESC LIMIT 1";
        var con = getConn();
        var code = queryRunner.query(con, scl, new ScalarHandler<String>());
        return new DataHelper.VerificationCode(code);
    }

    @SneakyThrows
    public static void cleanDatabase(){
        var connection = getConn();
        queryRunner.execute(connection, "DELETE FROM auth_codes");
        queryRunner.execute(connection, "DELETE FROM card_transactions");
        queryRunner.execute(connection, "DELETE FROM cards");
        queryRunner.execute(connection, "DELETE FROM users");
    }

}
