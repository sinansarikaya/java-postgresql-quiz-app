import java.sql.*;

public class QuestionPgRepository implements Irepository {
    private final String URL = "jdbc:postgresql://localhost:5432/questions";
    private final String USER = "techpront";
    private final String PASSWORD = "password";
    private Connection conn;
    private Statement st;
    private PreparedStatement prst;

    private void setConnection() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setStatement() {
        try {
            this.st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void PreparedStatement(String sql) {
        try {
            this.prst = conn.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertQuestion(Question question) {
        setConnection();
        String insertQuery =
                "INSERT INTO questions(question,answer,option1,option2,option3,option4) VALUES(?,?,?,?,?,?)";
        PreparedStatement(insertQuery);
        try {
            prst.setString(1, question.getQuestion());
            prst.setString(2, question.getAnswer());
            prst.setString(3, question.getOption1());
            prst.setString(4, question.getOption2());
            prst.setString(5, question.getOption3());
            prst.setString(6, question.getOption4());
            prst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void getQuestion(int id) {
        setConnection();
        String getQuery = "SELECT * FROM questions WHERE id = ?";
        PreparedStatement(getQuery);
        try {
            prst.setInt(1, id);
            ResultSet rs = prst.executeQuery();
            while (rs.next()){
                //TODO: Ihtiyaca gore karar verecegiz.
                //TODO: Okundu ibaresi konabilir
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                prst.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void getQuestions() {
        setConnection();
        setStatement();
        try {
            ResultSet rst = st.executeQuery("SELECT * FROM questions");
            while (rst.next()) {
                int id = rst.getInt("id");
                String question = rst.getString("question");
                String answer = rst.getString("answer");
                String option1 = rst.getString("option1");
                String option2 = rst.getString("option2");
                String option3 = rst.getString("option3");
                String option4 = rst.getString("option4");
                System.out.println(id + " - " + question);
                System.out.println("A - " + option1);
                System.out.println("B - " + option2);
                System.out.println("C - " + option3);
                System.out.println("D - " + option4);
                //TODO: Yukaridaki kodlar liste atilabilir
                //TODO: cevap kontrolu
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void updateQuestion(Question question) {
//        setConnection();
//
//        try {
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//
//                conn.close();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }

    @Override
    public void deleteQuestion(int id) {
//        setConnection();
//
//        try {
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//
//                conn.close();
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }
    }
}
