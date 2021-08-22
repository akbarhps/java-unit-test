# [Java Unit Test](https://akbarhps.github.io/java-unit-test/)

In computer programming, unit testing is a software testing method by which individual units of source code—sets of one
or more computer program modules together with associated control data, usage procedures, and operating procedures—are
tested to determine whether they are fit for use. [Wikipedia](https://en.wikipedia.org/wiki/Unit_testing)

[Official User Guide](https://junit.org/junit5/docs/current/user-guide/)

Sumber Tutorial:
[Youtube](https://www.youtube.com/watch?v=0jreaBRIOTo) |
[Slide](https://docs.google.com/presentation/d/1jaRXrZbMDCAubVs3annSlP2Mw2aTl67lqW40ysVRvKg/edit)

Sebelum Belajar Materi Ini:

- [Java Dasar](https://www.youtube.com/watch?v=jiUxHm9l1KY)
- [Java Object Oriented Programming](https://www.youtube.com/watch?v=f3ZhNnvtV-w)
- [Java Generic](https://www.youtube.com/watch?v=bvWRDAl30Gs)
- [Java Collection](https://www.youtube.com/watch?v=_JEMfq4k2O4)
- [Java Lambda](https://www.youtube.com/watch?v=AtF2EHZ1fXo)
- [Apache Maven](https://www.youtube.com/watch?v=VYA7NzIZFdg)

## Daftar Isi

- [Pengenalan Software Testing](#pengenalan-test)
- [Pengenalan JUnit](#pengenalan-junit)
- [Membuat Test](#membuat-test)
- [Menggunakan Assertions](#assertions)
- [Mengubah Nama Test](#mengubah-nama)
- [Menonaktifkan Test](#nonaktifkan-test)
- [Sebelum & Setelah Test](#sebelum-setelah-test)
- [Membatalkan Test](#membatalkan-test)
- [Menggunakan Assumptions](#assumptions)
- [Test Berdasarkan Kondisi](#test-kondisional)
- [Menggunakan Tag](#menggunakan-tag)
- [Urutan Eksekusi  Test](#urutan-eksekusi)
- [Siklus Hidup Test](#siklus-hidup)
- [Test di dalam Test](#test-didalam-test)
- [Informasi Test](#informasi-test)
- [Dependency Injection di Test](#dependency-injection)
- [Pewarisan di Test](#pewarisan-test)
- [Test Berulang](#test-berulang)
- [Test dengan Parameter](#test-parameter)
- [Timeout di Test](#timeout)
- [Eksekusi Test Secara Paralel](#test-paralel)
- [Pengenalan Mocking](#pengenalan-mocking)
- [Mocking di Test](#mocking-test)
- [Verifikasi di Mocking](#verifikasi-mocking)

---

## <span name="pengenalan-test">Pengenalan Software Testing</span>

- Software testing adalah salah satu disiplin ilmu dalam software engineering
- Tujuan utama dari software testing adalah memastikan kualitas kode dan aplikasi kita baik
- Ilmu untuk software testing sendiri sangatlah luas, pada materi ini kita hanya akan fokus ke unit testing

### Test Pyramid

![Test Pyramid](https://user-images.githubusercontent.com/69947442/130351720-2aa486fd-0d80-4c8f-bd60-94b1577a76d8.png)

### Contoh High Level Architecture

![Contoh High Level Architecture](https://user-images.githubusercontent.com/69947442/130351719-bf046083-efe4-4302-ab3b-8178657da2d4.png)

### UI Test/End to End Test

![UI Test/End to End Test](https://user-images.githubusercontent.com/69947442/130351716-6a687abb-3a65-40ba-b97a-cb9c66a85b25.png)

### Service Test/Integration Test

![Service Test/Integration Test](https://user-images.githubusercontent.com/69947442/130351715-729cd059-bdd0-40e3-a3a0-b3c3cbc17aed.png)

### Contoh Internal Architecture Aplikasi

![Contoh Internal Architecture Aplikasi](https://user-images.githubusercontent.com/69947442/130351713-d4f24a66-b033-4b5e-98ea-a1c90db5ff93.png)

### Unit Test

![Unit Test](https://user-images.githubusercontent.com/69947442/130351711-44986ea7-e429-41ed-9a90-02939e84f104.png)

- Unit test akan fokus menguji bagian kode program terkecil, biasanya menguji sebuah class dan method
- Unit test biasanya dibuat kecil dan cepat, oleh karena itu biasanya kadang kode unit test lebih banyak dari kode
  program aslinya, karena semua skenario pengujian akan dicoba di unit test
- Unit test bisa digunakan sebagai cara untuk meningkatkan kualitas kode program kita

---

## <span name="pengenalan-junit">Pengenalan JUnit</span>

- JUnit adalah test framework yang paling populer di Java
- Saat ini versi terbaru JUnit adalah versi 5
- JUnit 5 membutuhkan minimal Java versi 8
- [Official Website](https://junit.org/)

### Membuat Project Menggunakan Maven

### `mvn archetype:generate`

![mvn archetype:generate](https://user-images.githubusercontent.com/69947442/130352056-feae52cf-92bb-4746-ac83-50a3ca068dae.png)

### `mvn-archetype-quickstart`

![mvn-archetype-quickstart](https://user-images.githubusercontent.com/69947442/130352044-e3b9f9aa-3170-4832-9ed9-feaf1a519506.png)

### [Maven Central JUnit](https://search.maven.org/artifact/org.junit.jupiter/junit-jupiter)

---

## <span name="membuat-test">Membuat Test</span>

- Untuk membuat test di JUnit itu sederhana, kita cukup membuat class, lalu menambahkan method-method testnya
- Method akan di anggap sebuah test jika ditambahkan annotation `@Test`
- Kode test disimpan dibagian test folder di maven, bukan di main folder
- Biasanya saat membuat class untuk test, rata-rata orang biasa membuat nama classnya sama dengan nama class yang akan
  di test, tapi diakhiri dengan kata Test, misal nama classnya adalah Calculator, maka nama class testnya adalah
  CalculatorTest

### Kode

```java
public class CalculatorTest {
    public static final Calculator calculator = new Calculator();

    @Test
    public void testAddSuccess() {
        int result = calculator.add(5, 15);
    }
}
```

---

## <span name="assertions">Menggunakan Assertions</span>

- Saat membuat test, kita harus memastikan bahwa test tersebut sesuai dengan ekspektasi yang kita inginkan
- Jika manual, kita bisa melakukan pengecekan if else, namun itu tidak direkomendasikan
- JUnit memiliki fitur untuk melakukan assertions, yaitu memastikan bahwa unit test sesuai dengan kondisi yang kita
  inginkan
- Assertions di JUnit di representasikan dalam class Assertions, dan di dalamnya terdapat banyak sekali function static
- [Official Documentation](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html)

### Meng-import Assertions

```java
import static org.junit.jupiter.api.Assertions.*;
```

### Menggunakan Assertions

```java
public class CalculatorTest {
    public static final Calculator calculator = new Calculator();

    @Test
    public void testAddSuccess() {
        int result = calculator.add(5, 15);
        assertEquals(20, result);
    }
}
```

### Menggagalkan Test

- Kadang dalam membuat unit test, kita tidak hanya ingin mengetest kasus sukses atau gagal
- Ada kalanya kita ingin mengetes sebuah exception misalnya
- Assertions juga bisa digunakan untuk mengecek apakah sebuah exception terjadi

```java
public class CalculatorTest {
    public static final Calculator calculator = new Calculator();

    @Test
    public void testDivideFailed() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(100, 0));
    }
}
```

## <span name="mengubah-nama">Mengubah Nama Test</span>

- Kadang agak sulit membuat nama function yang merepresentasikan kasus testnya
- Jika kita ingin menambahkan deskripsi untuk tiap test, kita bisa menggunakan annotation `@DisplayName`
- Dengan menggunakan annotation `@DisplayName`, kita bisa menambahkan deskripsi unit testnya

### Menggunakan Display Name Generator

- JUnit mendukung pembuatan DisplayName secara otomatis menggunakan generator
- Yang perlu kita lakukan adalah membuat class turunan dari interface DisplayNameGenerator, lalu menambahkan
  annotation `@DisplayNameGenerator` di test classnya

```java
public class SimpleDisplayNameGenerator implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(Class<?> aClass) {
        return "Test " + aClass.getName();
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> aClass, Method method) {
        return "Test " + aClass.getSimpleName() + "." + method.getName();
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> aClass) {
        return null;
    }
}
```

---

## <span name="nonaktifkan-test">Menonaktifkan Test</span>

- Kadang ada kalanya kita ingin menonaktifkan unit test, misal karena terjadi error di unit test tersebut dan belum bisa
  kita pakai
- Sebenarnya cara paling mudah untuuk menonaktifkan unit test adalah dengan menghapus annotation `@Test`, namun jika
  kita lakukan itu, kita tidak bisa mendeteksi kalo ada unit test yang di disable
- Untuk menonaktifkan unit test secara benar, kita bisa menggunakan annotation `@Disabled`

```java
public class CalculatorTest {
    @Test
    @Disabled
    public void testNotImplemented() {
        // not yet implemented
    }
}
```

---

## <span name="sebelum-setelah-test">Sebelum & Setelah Test</span>

- Kadang kita ingin menjalankan kode yang sama sebelum dan setelah eksekusi unit test
- Hal ini sebenarnya bisa dilakukan secara manual di function `@Test` nya, namun hal ini akan membuat kode duplikat
  banyak sekali
- JUnit memiliki annotation `@BeforeEach` dan `@AfterEach`
- `@BeforeEach` digunakan untuk menandai function yang akan dieksekusi sebelum unit test dijalankan
- `@AfterEach` digunakan untuk menandai function yang dieksekusi setelah unit test dijalankan. Ingat, bahwa ini akan
  selalu dieksekusi setiap kali untuk function `@Test`, bukan sekali untuk class test saja

```java
public class CalculatorTest {
    @BeforeEach
    void setUp() {
        System.out.println("Run Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run After Each");
    }
}
```

### Sebelum & Setelah Semua Unit Test

- `@BeforeEach` & `@AfterEach` akan dieksekusi setiap kali function `@Test` jalan
- Namun kadang kita ingin melakukan sesuatu sebelum semua unit test berjalan, atau setelah semua unit test berjalan
- Ini bisa dilakukan dengan menggunakan annotation `@BeforeAll` & `@AfterAll`
- Namun hanya static function yang bisa menggunakan `@BeforeAll` & `@AfterAll`

```java
public class CalculatorTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Run Before All");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Run After All");
    }
}
```

---

## <span name="membatalkan-test">Membatalkan Test</span>

- Kadang kita ingin membatalkan unit test ketika kondisi tertentu terjadi
- Untuk membatalkan, kita bisa menggunakan exception `TestAbortedException`
- Jika JUnit mendapatkan exception `TestAbortedException`, secara otomatis test tersebut akan dibatalkan

```java
public class CalculatorTest {
    @Test
    public void testAborted() {
        String profile = System.getenv("PROFILE");
        if (profile == null || !profile.equals("DEV")) {
            throw new TestAbortedException("Not in dev env");
        }
    }
}
```

---

## <span name="assumptions">Menggunakan Assumptions</span>

- Sebelumnya kita sudah tahu jika ingin membatalkan test, kita bisa menggunakan `TestAbortException`
- Namun sebenarnya ada cara yang lebih mudah, yaitu dengan menggunakan Assumptions
- Penggunaan Assumptions mirip seperti Assertions, jika nilainya tidak sama, maka function Assumptions akan
  throw `TestAbortedException`, sehingga secara otomatis akan membatalkan test yang sedang berjalan
- [Official Documentation](https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assumptions.html)

### Meng-import Assumptions

```java
import static org.junit.jupiter.api.Assumptions.*;
```

### Menggunakan Assumptions

```java
public class CalculatorTest {
    @Test
    public void testAssumptions() {
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
```

---

## <span name="test-kondisional">Test Berdasarkan Kondisi</span>

- Sebenarnya kita bisa menggunakan Assumptions untuk menjalankan unit test berdasarkan kondisi tertentu
- Namun JUnit menyediakan fitur yang lebih mudah untuk pengecekan beberapa kondisi, seperti kondisi sistem operasi,
  versi java, system property atau environment variable
- Ini lebih mudah dibandingkan menggunakan Assumptions

### Kondisi Sistem Operasi

- Untuk kondisi sistem operasi, kita bisa menggunakan beberapa annotation
- `@EnabledOnOs` digunakan untuk penanda bahwa unit test berjalan di sistem operasi yang di tentukan
- `@DisabledOnOs` digunakan untuk penanda bahwa unit test tidak boleh berjalan di sistem operasi yang di tentukan

```java
public class ConditionTest {
    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnWindows() {
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisableOnWindows() {
    }
}
```

### Kondisi Versi Java

- Untuk kondisi versi Java yang kita gunakan, kita bisa menggunakan beberapa annotation
- `@EnabledOnJre` digunakan untuk penanda bahwa unit test boleh berjalan di Java versi tertentu
- `@DisbledOnJre` digunakan untuk penanda bahwa unit test tidak boleh berjalan di Java versi tertentu
- `@EnabledForJreRange` digunakan untuk penanda bahwa unit test boleh berjalan di range Java versi tertentu
- `@DisabledForJreRange` digunakan untuk penanda bahwa unit test tidak boleh berjalan di range Java versi tertentu

```java
public class ConditionTest {
    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testEnableOnJava11To15() {
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_15)
    public void testDisableOnJava11To15() {
    }
}
```

### Kondisi System Property

- Untuk kondisi nilai dari system property, kita bisa menggunakan beberapa annotation
- `@EnabledIfSystemProperty` untuk penanda bahwa unit test boleh berjalan jika system property sesuai dengan yang
  ditentukan
- `@DisabledIfSystemProperty` untuk penanda bahwa unit test tidak boleh berjalan jika system property sesuai dengan yang
  ditentukan
- Jika kondisinya lebih dari satu, kita bisa menggunakan `@EnabledIfSystemProperties` dan `@DisabledIfSystemProperties`

```java
public class ConditionTest {
    @Test
    @EnabledIfSystemProperties(
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    )
    void testEnabledOnJavaOracle() {
    }

    @Test
    @DisabledIfSystemProperties(
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    )
    void testDisabledOnJavaOracle() {
    }
}
```

### Kondisi Environment Variable

- Untuk kondisi nilai dari environment variable, kita bisa menggunakan beberapa annotation
- `@EnabledIfEnvironmentVariable` untuk penanda bahwa unit test boleh berjalan jika environment variable sesuai dengan
  yang ditentukan
- `@DisabledIfEnvironmentVariable` untuk penanda bahwa unit test tidak boleh berjalan jika environment variable sesuai
  dengan yang ditentukan
- Jika kondisi lebih dari satu, kita bisa menggunakan `@EnabledIfEnvironmentVariables`
  dan `@DisabledIfEnvironmentVariables`

```java
public class ConditionTest {
    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnDev() {
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledOnDev() {
    }
}
```

---

## <span name="menggunakan-tag">Menggunakan Tag</span>

- Class atau function unit test bisa kita tambahkan tag (tanda) dengan menggunakan annotation `@Tag`
- Dengan menambahkan tag ke dalam unit test, kita bisa fleksibel ketika menjalankan unit test, bisa memilih tag mana
  yang mau di include atau di exclude
- Jika kita menambahkan tag di class unit test, secara otomatis semua function unit test di dalam class tersebut akan
  memiliki tag tersebut
- JIka kita ingin menambahkan beberapa tag di satu class atau function unit test, kita bisa menggunakan
  annotation `@Tags`

### Menambahkan Tag

```java

@Tag("integration-test")
public class SampleIntegrationTest {
    @Test
    void test1() {
    }
}
```

### Menjalankan Test Berdasarkan Tag dengan Maven

`mvn test -Dgroups=namatag`

---

## <span name="urutan-eksekusi">Urutan Eksekusi Test</span>

- Secara default, urutan eksekusi unit test tidak ditentukan, jadi jangan berharap jika sebuah method berada di atas
  method lainnya, maka akan dijalankan lebih dulu
- Hal ini karena memang sebaiknya method unit test itu harus independen, tidak saling ketergantungan
- Secara default pun, object class unit test akan selalu dibuat ulang tiap method, jadi jangan berharap kita bisa
  menyimpan data di variable untuk digunakan di unit test method selanjutnya

### Mengubah Urutan Eksekusi Test

- JUnit mendukung perubahan urutan eksekusi test jika kita mau menggunakan annotation `@TestMethodOrder`, ada beberapa
  cara yang bisa kita lakukan
- Alphanumeric, artinya urutan eksekusi unit test akan diurutkan berdasarkan alphanumeric (deprecated)
- MethodName, artinya urutan eksekusi unit test akan diurutkan berdasarkan nama method
- Random, artinya urutan eksekusi unit test akan dieksekusi secara random
- OrderAnnotation, artinya urutan eksekusi unit test akan mengikuti annotation `@Order` yang ada di tiap method unit
  test

```java

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    @Test
    @Order(1)
    void test3() {
    }

    @Test
    @Order(3)
    void test2() {
    }
}
```

---

## <span name="siklus-hidup">Siklus Hidup Test</span>

- Secara default, lifecycle (siklus hidup) object test adalah independent er method test, artinya object unit test akan
  selalu dibuat per method unit test, oleh karena itu kita tidak bisa bergantung dengan method test lain
- Cara pembuatan object test di JUnit ditentukan oleh annotation `@TestInstance`, dimana defaultnya
  adalah `Lifecycle.PER_METHOD`, artinya tiap method akan dibuat sebuah instance/object baru
- Kita bisa merubahnya menjadi `Lifecycle.PER_CLASS` jika mau, dengan demikian instance/object test hanya dibuat sekali
  per class, dan method test akan menggunakan object test yang sama
- Hal ini bisa kita manfaatkan ketika membuat test yang bergantung dengan test lain

```java

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class LifecycleTest {
    private int runCounter = 0;

    @Test
    void testA() {
        runCounter++;
        System.out.println(runCounter);
    }

    @Test
    void testB() {
        runCounter++;
        System.out.println(runCounter);
    }
}
```

### Keuntungan Instance Per Class

- Salah satu keuntungan saat menggunakan `Lifecycle.PER_CLASS` adalah, kita bisa menggunakan @BeforeAll dan @AfterAll di
  method biasa, tidak harus menggunakan function static

---

## <span name="test-didalam-test">Test di dalam Test</span>

- Saat membuat unit test, ada baiknya ukuran test class nya tidak terlalu besar, karena akan sulit di baca dan di
  mengerti
- Jika test class sudah semakin besar, ada baiknya kita pecah menjadi beberapa test class, lalu kita grouping sesuai
  dengan jenis method testnya
- JUnit mendukung pembuatan class test di dalam class test, jadi kita bisa memecah sebuah class test, tanpa harus
  membuat class di file berbeda, kita bisa cukup menggunakan inner class
- Untuk memberi tahu bahwa inner class tersebut adalah test class, kita bisa menggunakan annotation `@Nested`

```java
public class QueueTest {
    private Queue<String> queue;

    @Nested
    public class WhenOffer {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<>();
        }

        @Test
        void testWhenOfferSizeMustBeIncreasing() {
            queue.offer("Hello");
            Assertions.assertEquals(1, queue.size());
        }
    }
}
```

---

## <span name="informasi-test">Informasi Test</span>

- Walaupun mungkin jarang kita gunakan, tapi kita juga bisa mendapatkan informasi test yang sedang berjalan menggunakan
  interface `TestInfo`
- Kita bisa menambahkan `TestInfo` sebagai parameter di function unit test

![TestInfo Interface](https://user-images.githubusercontent.com/69947442/130357251-0776454b-fa95-492c-a40a-1628dfe60430.png)

```java

@DisplayName("Information Test")
public class InformationTest {
    @Test
    @DisplayName("This is test 1")
    @Tags({
            @Tag("Test1"),
            @Tag("Test2"),
    })
    void test1(TestInfo info) {
        System.out.println(info);
    }
}
```

---

## <span name="dependency-injection">Dependency Injection di Test</span>

- Tidak ada magic di JUnit, sebenarnya fitur TestInfo yang sebelumnya kita bahas adalah bagian dari Dependency Injection
  di JUnit
- Dependency Injection secara sederhana adalah bagaimana kita bisa memasukkan dependency (object/instance) ke dalam unit
  test secara otomatis tanpa proses manual
- Saat kita menambah parameter di function unit test, sebenarnya kita bisa secara otomatis memasukkan parameter tersebut
  dengan bantuan `ParameterResolver`
- Contohnya TestInfo yang kita bahas sebelumnya, sebenarnya objectnya dibuat oleh `TestInfoParameterResolver`

### Membuat Parameter Resolver

```java
public class RandomParameterResolver implements ParameterResolver {
    private Random random = new Random();

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Random.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return random;
    }
}
```

### Menggunakan Parameter Resolver

- Untuk menggunakan Parameter Resolver yang sudah kita buat, kita bisa menggunakan annotation `@ExtendWith` di test
  class
- Jika lebih dari 1 Parameter Resolver, kita bisa menggunakan `@Extensions`

```java

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        var expected = a + b;
        Assertions.assertEquals(expected, result);
    }
}
```

---

## <span name="pewarisan-test">Pewarisan Test</span>

- JUnit mendukung pewarisan di test, artinya jika kita membuat class atau interface dan menambahkan informasi test
  disitu, maka ketika kita membuat turunannya, secara otomatis semua fitur test nya dimiliki oleh turunannya
- Ini sangat cocok digunakan pada saat kita sering membuat code sebelum dan setelah test yang berulang-ulang, sehingga
  dibanding dibuat di semua test class, lebih baik dibuat sekali di parent test class, dan test class tinggal menjadi
  child class dari parent test class

```java

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {
    protected final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll() {
        System.out.println("Abstract Calculator Test Start");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Abstract Calculator Test End");
    }
}
```

---

## <span name="test-berulang">Test Berulang</span>

- JUnit mendukung eksekusi unit test berulang kali sesuai dengan jumlah yang kita tentukan
- Untuk mengulang eksekusi unit test, kita bisa menggunakan annotation `@RepeatedTest` di method unit test nya
- `@RepeatedTest` juga bisa digunakan untuk mengubah detail nama test nya, dan kita bisa menggunakan
  value `{displayName}`
  untuk mendapatkan display name, `{currentRepetition}` untuk mendapatkan perulangan ke berapa saat ini,
  dan `{totalRepetitions}` untuk mendapatkan total perulangan nya

```java
public class RandomCalculatorTest extends AbstractCalculatorTest {
    @RepeatedTest(
            value = 10,
            name = "{displayName} iterasi ke {currentRepetition} dari total {totalRepetitions}"
    )
    void testRandomRepeat(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        var expected = a + b;
        Assertions.assertEquals(expected, result);
    }
}
```

### Informasi Perulangan

- `@RepeatedTest` juga memiliki object `RepetitionInfo` yang di inject oleh class `RepetitionInfoParameterResolver`,
  sehingga kita bisa mendapatkan informasi `RepetitionInfo` melalui parameter function unit test

```java
public class RandomCalculatorTest extends AbstractCalculatorTest {
    @RepeatedTest(value = 10)
    void testRandomRepeatInfo(Random random, RepetitionInfo info) {
        System.out.println(info.getCurrentRepetition() + " from " + info.getTotalRepetitions());
        var a = random.nextInt();
        var b = random.nextInt();
        var result = calculator.add(a, b);
        var expected = a + b;
        Assertions.assertEquals(expected, result);
    }
}
```

---

## <span name="test-parameter">Test dengan Parameter</span>

- Sebelumnya kita sudah tau jika ingin menambahkan parameter di function unit test, maka kita perlu
  membuat `ParameterResolver`
- Namun jika terlalu banyak membuat `ParameterResolver` juga agak menyulitkan kita
- JUnit memiliki fitur yang bernama `@ParameterizedTest`, dimana jenis unit test ini memang khusus dibuat agar dapat
  menerima parameter
- Yang perlu kita lakukan adalah dengan mengganti `@Test` menjadi `@ParameterizedTest`

### Sumber Parameter

`@ParameterizedTest` mendukung beberapa sumber parameter, yaitu

- `@ValueSource`, untuk sumber Number, Char, Boolean dan String
- `@EnumSource`, untuk sumber berupa enum
- `@MethodSource`, untuk sumber dari static method
- `@CsvSource`, untuk sumber berupa data CSV
- `@CsvFileSource`, untuk sumber berupa file CSV
- `@ArgumentSource`, untuk data dari class `ArgumentProvider`

### Parameter dengan Value Source

```java
public class RandomCalculatorTest extends AbstractCalculatorTest {
    @DisplayName("Test Calculator Parameterize")
    @ParameterizedTest(name = "{displayName} jalan dengan parameter {0}")
    @ValueSource(ints = {1, 22, 3, 4, 5})
    void testCalculatorValueSource(int value) {
        int expected = value + value;
        int result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }
}
```

### Parameter dengan Method Source

```java
public class RandomCalculatorTest extends AbstractCalculatorTest {
    public static List<Integer> parameterSource() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("Test Calculator Method Source")
    @ParameterizedTest(name = "{displayName} jalan dengan parameter {0}")
    @MethodSource(value = {"parameterSource"})
    void testCalculatorMethodSource(int value) {
        int expected = value + value;
        int result = calculator.add(value, value);
        Assertions.assertEquals(expected, result);
    }
}
```

---

## <span name="timeout">Timeout di Test</span>

## <span name="test-paralel">Eksekusi Test Secara Paralel</span>

## <span name="pengenalan-mocking">Pengenalan Mocking</span>

## <span name="mocking-test">Mocking di Test</span>

## <span name="verifikasi-mocking">Verifikasi Mocking</span>
