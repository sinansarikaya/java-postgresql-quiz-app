# Java ile PostgreSQL Bağlantılı Basit Quiz Uygulaması

Bu proje, temel Java ve OOP (Object-Oriented Programming) kullanarak PostgreSQL veritabanıyla bağlantılı basit bir quiz uygulaması oluşturmayı amaçlamaktadır. Projede, veritabanı işlemleri için bir `QuestionRepository` sınıfı, soruları temsil etmek için bir `Question` sınıfı, uygulamayı başlatmak ve kullanıcıya soruları sormak için bir `Main` sınıfı ve bir `Menu` sınıfı bulunmaktadır.

## Gereklilikler

- Java 11 veya daha yeni bir sürüm
- PostgreSQL veritabanı

## Uygulamanın Genel Amacı

Bu uygulama, kullanıcılara bir dizi soru sorarak bilgi seviyelerini test etmeyi amaçlar. Kullanıcılar her doğru cevap verdiklerinde puan kazanırlar. Quiz sonunda, kullanıcının aldığı puan ekrana yazdırılır.

## Class İsimleri ve Amaçları

- **QuestionRepository:** Veritabanı işlemleri için kullanılan sınıf.
- **Question:** Soruları temsil eden POJO (Plain Old Java Object) sınıfı.
- **Main:** Uygulamanın ana sınıfı.
- **Menu:** Uygulamanın menüsünü oluşturan sınıf.

## Değişken İsimleri, Tipleri ve Amaçları

### QuestionRepository sınıfı:

- **URL:** Veritabanı bağlantı URL'si (final String).
- **USER:** Veritabanı kullanıcı adı (final String).
- **PASSWORD:** Veritabanı parolası (final String).
#### CRUD İşlemleri
`QuestionRepository` sınıfı, veritabanı işlemleri için aşağıdaki CRUD (Create, Read, Update, Delete) işlemlerini destekler:
- `insertQuestion(Question question)`: Bir soruyu veritabanına ekler.
- `getQuestion(int id)`: Belirtilen kimliğe sahip soruyu veritabanından alır.
- `getQuestions()`: Tüm soruları veritabanından alır.
- `updateQuestion(Question question)`: Veritabanındaki bir soruyu günceller.
- `deleteQuestion(int id)`: Belirtilen kimliğe sahip soruyu veritabanından siler.

### Question sınıfı:

- **id:** Sorunun kimliği (int).
- **question:** Sorunun metni (String).
- **answer:** Sorunun doğru cevabı (String).
- **option1:** Sorunun birinci seçeneği (String).
- **option2:** Sorunun ikinci seçeneği (String).
- **option3:** Sorunun üçüncü seçeneği (String).
- **option4:** Sorunun dördüncü seçeneği (String).

### Main sınıfı:

- **questionRepository:** `QuestionRepository` sınıfının bir örneği.
- **questions:** Veritabanından alınan soruların bir listesi (List<Question>).
- **scanner:** Kullanıcıdan girdi almak için kullanılan bir `Scanner`.
- **score:** Kullanıcının aldığı puan (int).

### Menu sınıfı:

- **options:** Menü seçeneklerinin bir listesi (List<String>).
- **selectedOption:** Seçilen menü seçeneği (int).

## Veritabanı İsmi, Tablo İsmi ve Kolon İsimleri


- **Veritabanı İsmi:** quiz
- **Tablo İsmi:** questions
- **Kolon İsimleri:**
    - **id:** Sorunun kimliği (SERIAL, PRIMARY_KEY).
    - **question:** Sorunun metni (VARCHAR).
    - **answer:** Sorunun doğru cevabı (CHAR).
    - **option1:** Sorunun birinci seçeneği (VARCHAR).
    - **option2:** Sorunun ikinci seçeneği (VARCHAR).
    - **option3:** Sorunun üçüncü seçeneği (VARCHAR).
    - **option4:** Sorunun dördüncü seçeneği (VARCHAR).

## Değişkenlerin Sabit Olması

`QuestionRepository` sınıfındaki değişkenler, `final` özelliği kullanılarak sabit olarak tanımlanmıştır. Bu, bu değişkenlerin değiştirilmesini engeller ve uygulamanın daha kararlı ve güvenilir olmasını sağlar.

## Menü

`Menu` sınıfı, uygulamaya bir menü ekler. Bu sınıfıta, kullanıcının menüden yaptığı seçime göre `switch case` kullanılarak uygun işlemler gerçekleştirilir. Bu menü, kullanıcıya aşağıdaki seçenekleri sunar:

1: Soru ekle
2: Soru sil
3: Quiz başlat
0: Çıkış
