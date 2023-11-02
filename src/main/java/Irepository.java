import java.util.List;

public interface Irepository {
    public void insertQuestion(Question question);
    public void getQuestion(int id);
    public List<Question> getQuestions();
    public void updateQuestion(Question question);
    public void deleteQuestion(int id);
}
