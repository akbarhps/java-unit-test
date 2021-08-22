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

## <span name="nonaktifkan-test">Menonaktifkan Test</span>

## <span name="sebelum-setelah-test">Sebelum & Setelah Test</span>

## <span name="membatalkan-test">Membatalkan Test</span>

## <span name="assumptions">Menggunakan Assumptions</span>

## <span name="test-kondisional">Test Berdasarkan Kondisi</span>

## <span name="menggunakan-tag">Menggunakan Tag</span>

## <span name="urutan-eksekusi">Urutan Eksekusi Test</span>

## <span name="siklus-hidup">Siklus Hidup Test</span>

## <span name="test-didalam-test">Test di dalam Test</span>

## <span name="informasi-test">Informasi Test</span>

## <span name="dependency-injection">Dependency Injection di Test</span>

## <span name="pewarisan-test">Pewarisan Test</span>

## <span name="test-berulang">Test Berulang</span>

## <span name="test-parameter">Test dengan Parameter</span>

## <span name="timeout">Timeout di Test</span>

## <span name="test-paralel">Eksekusi Test Secara Paralel</span>

## <span name="pengenalan-mocking">Pengenalan Mocking</span>

## <span name="mocking-test">Mocking di Test</span>

## <span name="verifikasi-mocking">Verifikasi Mocking</span>
