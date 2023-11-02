import java.util.List;
import java.util.Scanner;

public class QuestionService {

    QuestionPgRepository repository = new QuestionPgRepository();
    Question quiz = new Question();
    Scanner input = new Scanner(System.in);

    public void addQuestion() {
        System.out.println("Lütfen soru giriniz.");
        String question = input.nextLine();
        quiz.setQuestion(question);

        System.out.println("Lütfen şıkkı giriniz(a/b/c/d) cevap giriniz.");
        String answer = input.nextLine();
        quiz.setAnswer(answer);

        System.out.println("Lütfen a şıkkını giriniz.");
        String option1 = input.nextLine();
        quiz.setOption1(option1);

        System.out.println("Lütfen b şıkkını giriniz.");
        String option2 = input.nextLine();
        quiz.setOption2(option2);

        System.out.println("Lütfen c şıkkını giriniz.");
        String option3 = input.nextLine();
        quiz.setOption3(option3);

        System.out.println("Lütfen d şıkkını giriniz.");
        String option4 = input.nextLine();
        quiz.setOption4(option4);

        repository.insertQuestion(quiz);
    }

    public void getAll() {
        Irepository questionRepository = new QuestionPgRepository();
        List<Question> questions = questionRepository.getQuestions();

        int counter = 1;
        int score = 0;

        for (Question question : questions) {
            System.out.println("Soru " + counter + " : " + question.getQuestion());
            System.out.println("A - " + question.getOption1());
            System.out.println("B - " + question.getOption2());
            System.out.println("C - " + question.getOption3());
            System.out.println("D - " + question.getOption4());

            System.out.println("Cevap seciniz");
            String cevap = input.next();

            if(cevap.equalsIgnoreCase(question.getAnswer())){
                score += 10;
                System.out.println("Dogru cevap puaniniz " + score);
            } else {
                System.out.println("Yanlis cevap puaniniz " + score);
            }
            counter++;
        }
    }

}
