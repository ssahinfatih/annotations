# Spring Boot Annotations Learning Project

Bu proje, **Spring Boot üzerinde sık kullanılan annotation'ları öğrenmek, gerçek bir CRUD uygulaması içinde denemek ve hangi katmanda neden kullanıldıklarını görmek** amacıyla hazırlanmıştır.

Proje yalnızca annotation isimlerini ezberlemek yerine; **Spring Framework, Spring Boot, Spring Data JPA, Jakarta Validation, Spring Security, Spring AOP, Lombok ve Spring Boot Test** gibi teknolojilerin annotation'lar üzerinden nasıl birlikte çalıştığını göstermeyi hedefler.

---

## 🎯 Projenin Amacı

Bu projede temel hedefler:

- Spring Boot annotation'larının görevlerini öğrenmek
- Annotation'ların hangi teknolojiye ait olduğunu ayırt etmek
- Controller → Service → Repository → Database akışını anlamak
- DTO ve validation kullanımını görmek
- Spring Security ile authentication ve authorization mantığını uygulamak
- AOP ile merkezi loglama yaklaşımını öğrenmek
- Spring Boot test annotation'larını tanımak
- Lombok ile boilerplate kodu azaltmak
- Öğrenilen annotation'ları gerçek bir proje üzerinde deneyerek kalıcı hale getirmek

---

## 🛠️ Teknolojiler

- **Java**
- **Spring Boot 4.1.0**
- **Spring Web / Spring MVC**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Jakarta Validation**
- **Spring Security**
- **Spring AOP / AspectJ**
- **Lombok**
- **JUnit 5**
- **Mockito**
- **Spring Boot Test**
- **IntelliJ IDEA HTTP Client**
- **Postman** – özellikle Security testleri için
- **DBeaver** – PostgreSQL yönetimi için

---

# 🏗️ Mimari

Proje temel olarak katmanlı bir Spring Boot yapısı kullanır:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
JPA / Hibernate
    ↓
PostgreSQL
```

Buna ek olarak:

```text
Request
  ↓
Validation
  ↓
Security
  ↓
Controller
  ↓
Service
  ↓
Repository
```

ve AOP tarafında:

```text
Service Method
      ↓
    AOP
      ↓
Logging
      ↓
Gerçek Method
```

gibi bir yapı oluşturulmuştur.

---

# 📚 Öğrenilen Annotationlar

Aşağıdaki annotationlar proje kapsamında öğrenildi. Bazıları doğrudan uygulamaya eklendi, bazıları ise kullanım amacı ve gerçek hayattaki kullanım alanları anlaşılması için incelendi.

---

## 1. Spring Boot / Spring Core

| Annotation | Teknoloji | Ne öğrendik? |
|---|---|---|
| `@SpringBootApplication` | Spring Boot | Uygulamanın ana başlangıç annotation'ı. |
| `@Component` | Spring | Bir class'ı Spring tarafından yönetilen Bean haline getirir. |
| `@Service` | Spring | Service katmanındaki Bean'leri belirtir. |
| `@Repository` | Spring / Spring Data | Repository katmanını belirtir. |
| `@Controller` | Spring MVC | MVC Controller oluşturur. |
| `@RestController` | Spring MVC | REST Controller oluşturur ve response body'sini otomatik yönetir. |
| `@Configuration` | Spring | Configuration class oluşturur. |
| `@Bean` | Spring | Bir methodun döndürdüğü nesneyi Spring Bean'i yapar. |
| `@ComponentScan` | Spring | Spring Bean'lerini package'lar içinde tarar. |
| `@Import` | Spring | Belirli configuration/component'ları Spring context'ine dahil eder. |
| `@DependsOn` | Spring | Bir Bean'in başka bir Bean'den sonra oluşturulmasını sağlar. |
| `@Scope` | Spring | Bean'in yaşam alanını belirler (`singleton`, `prototype` vb.). |
| `@Lazy` | Spring | Bean'in oluşturulmasını ihtiyaç anına erteler. |
| `@Profile` | Spring | Bir Bean'in hangi profile göre aktif olacağını belirler. |
| `@Conditional` | Spring | Bir şart gerçekleşiyorsa Bean/configuration oluşturur. |

### Spring Boot Conditional ailesi

| Annotation | Basit anlamı |
|---|---|
| `@ConditionalOnBean` | Belirli Bean varsa oluştur. |
| `@ConditionalOnMissingBean` | Belirli Bean yoksa oluştur. |
| `@ConditionalOnClass` | Belirli class/dependency varsa oluştur. |
| `@ConditionalOnMissingClass` | Belirli class/dependency yoksa oluştur. |
| `@ConditionalOnProperty` | Property değerine göre oluştur. |

---

## 2. REST API / Spring MVC

| Annotation | Ne için kullanıldı? |
|---|---|
| `@RequestMapping` | Controller'ın temel URL yolunu belirlemek için. |
| `@GetMapping` | GET endpoint'leri için. |
| `@PostMapping` | POST endpoint'leri için. |
| `@PutMapping` | PUT endpoint'leri için. |
| `@DeleteMapping` | DELETE endpoint'leri için. |
| `@RequestBody` | JSON request body'sini Java nesnesine dönüştürmek için. |
| `@PathVariable` | URL içindeki değeri almak için. |
| `@RequestParam` | Query parameter almak için. |
| `@RequestHeader` | HTTP header içindeki değeri almak için. |
| `@ResponseBody` | Return edilen değeri HTTP response body olarak göndermek için. |
| `@CrossOrigin` | Farklı origin'den gelen browser isteklerine CORS izni vermek için. |
| `@InitBinder` | Spring MVC'nin request binding davranışını özelleştirmek için. |

---

## 3. DTO / Validation

DTO tarafında özellikle **Jakarta Validation** kullanıldı.

| Annotation | Teknoloji | Görevi |
|---|---|---|
| `@Valid` | Jakarta Validation / Spring | Validation kurallarını çalıştırır. |
| `@Validated` | Spring | Validation groups ve method validation gibi Spring özelliklerini destekler. |
| `@NotBlank` | Jakarta Validation | String'in null, boş veya sadece whitespace olmasını engeller. |
| `@NotNull` | Jakarta Validation | Değerin null olmasını engeller. |
| `@NotEmpty` | Jakarta Validation | Değerin null veya boş olmasını engeller. |
| `@Size` | Jakarta Validation | String/Collection/Array boyutunu kontrol eder. |
| `@Min` | Jakarta Validation | Minimum sayısal değeri belirler. |
| `@Max` | Jakarta Validation | Maksimum sayısal değeri belirler. |
| `@Positive` | Jakarta Validation | Sayının 0'dan büyük olmasını ister. |
| `@PositiveOrZero` | Jakarta Validation | Sayının 0 veya daha büyük olmasını ister. |
| `@Pattern` | Jakarta Validation | String'in regex formatına uygunluğunu kontrol eder. |

Örneğin DTO validation mantığı:

```text
@Valid
   ↓
@NotBlank
@Size
@Min / @Max
@Pattern
   ↓
Geçerli / Geçersiz
```

---

## 4. JPA / Spring Data JPA

| Annotation | Teknoloji | Görevi |
|---|---|---|
| `@Entity` | JPA | Class'ı database entity'si olarak tanımlar. |
| `@Id` | JPA | Primary key alanını belirtir. |
| `@GeneratedValue` | JPA | ID'nin otomatik oluşturulmasını sağlar. |
| `@Column` | JPA | Database column özelliklerini belirler. |
| `@Table` | JPA | Entity'nin hangi tabloyla ilişkili olduğunu belirler. |
| `@Transactional` | Spring | İşlemi transaction içinde yönetir. |
| `@EnableTransactionManagement` | Spring | Annotation tabanlı transaction yönetimini etkinleştirir; Spring Boot'ta çoğu zaman ayrıca yazmak gerekmez. |
| `@EnableJpaRepositories` | Spring Data JPA | JPA repository'lerini tarayıp etkinleştirir; Spring Boot çoğu durumda bunu otomatik yapar. |
| `@JoinTable` | JPA | İlişkiyi ayrı bir tablo üzerinden tutmak için kullanılır. |
| `@Embeddable` | JPA | Başka bir entity içine gömülebilen class tanımlar. |
| `@Embedded` | JPA | `@Embeddable` class'ı entity içine dahil eder. |
| `@EmbeddedId` | JPA | Birden fazla alandan oluşan primary key tanımlar. |
| `@MapsId` | JPA | ID bilgisini ilişkili entity'den kullanmaya yarar. |
| `@Transient` | JPA | Alanın database'e yazılmasını engeller. |

> Entity relationship annotationları (`@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`, `@JoinColumn`) daha önce çalışıldığı için bu projede ana eğitim akışında tekrar ele alınmadı.

---

## 5. Configuration / Properties

| Annotation | Görevi |
|---|---|
| `@ConfigurationProperties` | `application.properties` / `application.yml` değerlerini typed bir Java class'ına bağlar. |
| `@ConfigurationPropertiesScan` | `@ConfigurationProperties` class'larını package taramasıyla bulur. |
| `@Value` | Tek bir property değerini doğrudan field/method/constructor'a almak için kullanılır. |
| `@Profile` | Configuration'ın hangi profile göre aktif olacağını belirler. |
| `@ActiveProfiles` | Test sırasında hangi Spring profile'ın aktif olacağını belirler. |
| `@TestPropertySource` | Teste özel property değerleri veya property dosyaları tanımlar. |

---

# 🔐 Spring Security

Projede temel authentication ve authorization yapısı gerçek olarak uygulandı.

## Kullanılan yapı

```text
HTTP Request
     ↓
Spring Security
     ↓
Authentication
     ↓
Authorization
     ↓
Controller / Service
```

### Öğrenilen annotationlar

| Annotation | Teknoloji | Görevi |
|---|---|---|
| `@EnableWebSecurity` | Spring Security | Web security yapılandırmasını etkinleştirir. |
| `@EnableMethodSecurity` | Spring Security | Method seviyesinde security annotationlarını etkinleştirir. |
| `@PreAuthorize` | Spring Security | Method çalışmadan önce yetki kontrolü yapar. |
| `@PostAuthorize` | Spring Security | Method çalıştıktan sonra dönen sonuca göre yetki kontrolü yapar. |
| `@Secured` | Spring Security | Basit role/authority kontrolü yapar. |
| `@RolesAllowed` | Jakarta / Spring Security | Belirli rollere izin verir. |

## Uygulanan Security senaryosu

Projede eğitim amacıyla in-memory iki kullanıcı oluşturuldu:

```text
fatih / 1234
ROLE_USER

admin / 1234
ROLE_ADMIN
```

DELETE işleminde:

```java
@PreAuthorize("hasRole('ADMIN')")
```

kullanılarak sadece `ADMIN` rolünün silme işlemini yapmasına izin verildi.

Beklenen davranış:

```text
admin + DELETE → başarılı
fatih + DELETE → 403 Forbidden
kimlik doğrulama yok/yanlış → 401 Unauthorized
```

REST API eğitiminde CSRF kontrolü kapatıldı:

```java
.csrf(csrf -> csrf.disable())
```

> `{noop}` ile kullanılan şifreler yalnızca eğitim amacıyladır. Gerçek projelerde password encoder ve güvenli parola saklama kullanılmalıdır.

---

# ⚡ Spring AOP / AspectJ

Projede AOP kullanılarak Service katmanında merkezi loglama mantığı incelendi.

Temel yapı:

```text
Service Method
      ↓
    Aspect
      ↓
 Logging
      ↓
Gerçek Method
```

### Öğrenilen annotationlar

| Annotation | Görevi |
|---|---|
| `@Aspect` | Aspect class'ını belirtir. |
| `@Before` | Hedef methoddan önce çalışır. |
| `@Around` | Methodun öncesini/sonrasını kontrol eder; methodu çalıştırmaya karar verebilir. |
| `@AfterReturning` | Method başarılı şekilde sonuç döndürdükten sonra çalışır. |
| `@AfterThrowing` | Method exception fırlattığında çalışır. |
| `@Pointcut` | Hangi methodların advice tarafından yakalanacağını isimlendirip tekrar kullanılabilir hale getirir. |
| `@EnableAspectJAutoProxy` | AOP auto-proxy altyapısını manuel olarak açar; Spring Boot'ta AOP starter ile çoğu zaman ayrıca yazılmaz. |

## AOP loglama yaklaşımı

Örneğin `StudentServiceImpl` methodları için:

```text
[INFO] findAll() başladı.
[INFO] findAll() başarılı.
[INFO] findAll() tamamlandı. Süre: 42 ms
```

ve hata durumunda:

```text
[ERROR] findById() hata verdi: Student not found
```

gibi merkezi loglama yaklaşımı uygulandı.

AOP tarafında ayrıca `@Slf4j` ile gerçek logger kullanımına geçiş de öğrenildi.

---

# 🚨 Exception Management

REST API'de hataları merkezi olarak yönetmek için:

| Annotation | Görevi |
|---|---|
| `@RestControllerAdvice` | Controller'lardaki exception'ları merkezi olarak yönetir. |
| `@ExceptionHandler` | Belirli exception türlerini yakalar. |

Örneğin authorization hatasının yanlışlıkla `200 OK` dönmemesi için `AccessDeniedException` ayrı ele alınarak `403 Forbidden` döndürülmesi öğrenildi.

---

# 🧪 Spring Boot Test

Test tarafında farklı test seviyelerini ayırmayı öğrendik.

| Annotation | Ne test eder? |
|---|---|
| `@SpringBootTest` | Uygulamanın genel Spring context'ini / geniş integration senaryolarını test eder. |
| `@WebMvcTest` | Controller / MVC katmanını test eder. |
| `@DataJpaTest` | JPA / Repository katmanını test eder. |
| `@JsonTest` | JSON serialization / deserialization işlemlerini test eder. |
| `@ContextConfiguration` | Testte hangi Spring configuration'larının yükleneceğini belirler. |
| `@SpringJUnitConfig` | `@ExtendWith(SpringExtension.class)` + `@ContextConfiguration` yaklaşımını birleştirir. |
| `@ExtendWith` | JUnit 5'e extension ekler. |
| `@ActiveProfiles` | Testte aktif Spring profile'ını belirler. |
| `@TestPropertySource` | Teste özel property'ler sağlar. |
| `@DirtiesContext` | Test context'inin yenilenmesi gerektiğini belirtir. |
| `@Sql` | Test öncesi/sonrası SQL scriptleri çalıştırır. |

### Mockito / Spring Test

| Annotation | Görevi |
|---|---|
| `@Mock` | Mockito ile Spring'den bağımsız sahte nesne oluşturur. |
| `@MockitoBean` | Spring test context içindeki gerçek Bean'in yerine Mockito mock'u koyar. |
| `@MockitoSpyBean` | Gerçek Spring Bean'ini spy olarak sarar; gerçek methodlar çalışabilir ve çağrılar izlenebilir. |

> Spring Boot 4.1 ile eski `@MockBean` / `@SpyBean` API'leri yerine güncel `@MockitoBean` / `@MockitoSpyBean` yaklaşımı öğrenildi.

### Test katmanları

```text
@SpringBootTest
      ↓
Bütün uygulamaya yakın test

@WebMvcTest
      ↓
Controller

@DataJpaTest
      ↓
Repository / JPA

@JsonTest
      ↓
JSON
```

PostgreSQL kullanıldığı için `@DataJpaTest` sırasında embedded database'e geçme davranışı kapatılarak gerçek PostgreSQL DataSource'unun kullanılması öğrenildi.

---

# 🍃 Lombok

Projede boilerplate kodu azaltmak için Lombok annotationları da çalışıldı.

| Annotation | Kısa açıklama |
|---|---|
| `@Getter` | Getter methodları oluşturur. |
| `@Setter` | Setter methodları oluşturur. |
| `@NoArgsConstructor` | Parametresiz constructor oluşturur. |
| `@AllArgsConstructor` | Tüm field'ları alan constructor oluşturur. |
| `@RequiredArgsConstructor` | `final` / `@NonNull` alanlar için constructor oluşturur. |
| `@Data` | Getter, Setter, `toString`, `equals`, `hashCode` gibi temel methodları toplar. |
| `@Builder` | Builder pattern ile nesne oluşturmayı kolaylaştırır. |
| `@ToString` | `toString()` oluşturur. |
| `@EqualsAndHashCode` | `equals()` ve `hashCode()` oluşturur. |
| `@Slf4j` | SLF4J logger'ı otomatik oluşturur. |

Özellikle Spring service'lerinde constructor injection için:

```java
@RequiredArgsConstructor
@Service
public class StudentServiceImpl {

    private final StudentRepository studentRepository;
}
```

gibi bir yapı tercih edilebilir.

---

# 🧩 Ek Öğrenilen Annotationlar

Aşağıdaki annotationlar da öğrenildi; ancak hepsi projeye zorunlu olarak eklenmedi:

- `@ResponseBody`
- `@EnableTransactionManagement`
- `@EnableJpaRepositories`
- `@EnableAspectJAutoProxy`
- `@JoinTable`
- `@Embedded`
- `@Embeddable`
- `@EmbeddedId`
- `@MapsId`
- `@InitBinder`
- `@ConditionalOnBean`
- `@ConditionalOnMissingBean`
- `@ConditionalOnClass`
- `@ConditionalOnMissingClass`
- `@ConditionalOnProperty`

Bu annotationların amacı, gerçek projelerde karşılaşıldığında ne yaptıklarını anlayabilmektir. Gereksiz annotation ekleyerek mevcut mimariyi karmaşıklaştırmamak özellikle tercih edilmiştir.

---

# 🧠 Öğrenilen Temel Kavramlar

Bu proje yalnızca annotation listesi değildir. Annotationların altında şu kavramlar da çalışılmıştır:

### Spring Container

Spring'in Bean'leri oluşturması, yönetmesi ve birbirine bağlaması.

### Dependency Injection

```text
Controller
   ↓
Service
   ↓
Repository
```

bağımlılıklarının Spring tarafından verilmesi.

### Constructor Injection

`private final` + constructor mantığı ve Lombok `@RequiredArgsConstructor` kullanımı.

### Validation

```text
@Valid
   ↓
@NotBlank / @NotNull / @Size / ...
```

### Transaction

```text
@Transactional
   ↓
Database işlemleri
   ↓
Commit / Rollback
```

### Security

```text
Authentication
→ Kim olduğunu doğrula

Authorization
→ Ne yapmaya yetkisi var?
```

### AOP

```text
Ortak davranışları
ana iş kodundan ayırma
```

Özellikle logging, monitoring ve cross-cutting concern mantığı.

### Testing

Bir uygulamanın tamamını test etmek yerine gerekli katmanı hedefleyerek test yazma yaklaşımı.

---

# 🔄 Gerçekleştirilen Akış

Projede öğrenilen birçok teknoloji aynı CRUD uygulaması üzerinde bir araya getirildi:

```text
HTTP Request
     ↓
Spring Security
     ↓
Authentication / Authorization
     ↓
Validation
     ↓
Controller
     ↓
AOP Logging
     ↓
Service
     ↓
@Transactional
     ↓
Repository
     ↓
JPA / Hibernate
     ↓
PostgreSQL
```

Hata oluştuğunda:

```text
Exception
   ↓
@RestControllerAdvice
   ↓
@ExceptionHandler
   ↓
HTTP Error Response
```

Test tarafında:

```text
@SpringBootTest   → genel uygulama testi
@WebMvcTest       → Controller testi
@DataJpaTest      → Repository/JPA testi
@JsonTest         → JSON testi
```

---

# 📌 Projede Özellikle Öğrenilen Prensipler

- Annotation'ın yalnızca adını değil, **hangi teknolojiye ait olduğunu** ayırt etmek
- Bir annotation'ın **hangi probleme çözüm olduğunu** anlamak
- Gereksiz annotation kullanımından kaçınmak
- Spring Boot'un birçok özelliği otomatik yapılandırdığını anlamak
- `@Valid` ile validation kurallarının birlikte çalışmasını anlamak
- Authentication ve Authorization farkını gerçek endpoint üzerinde görmek
- `401 Unauthorized` ve `403 Forbidden` farkını anlamak
- AOP ile ortak davranışları merkezi hale getirmek
- Testleri katmanlara ayırmak
- PostgreSQL ile JPA testlerini gerçek database üzerinde çalıştırmak
- Lombok ile boilerplate kodu azaltmak

---

# 🚀 Öğrenme Özeti

Bu repository, **Spring Boot annotation'larını gerçek bir CRUD uygulaması üzerinde öğrenme notları + uygulama projesi** olarak kullanılabilir.

Özellikle şu teknolojiler arasında bağlantı kurmayı hedefler:

```text
Spring Boot
   ├── Spring MVC
   ├── Spring Data JPA
   ├── Jakarta Validation
   ├── Spring Security
   ├── Spring AOP
   └── Spring Boot Test

Lombok
   ↓
Boilerplate azaltma

PostgreSQL
   ↓
Gerçek database
```

---

## 👨‍💻 Author

**Fatih Şahin**

Spring Boot, Java, Spring Security, JPA, AOP ve Clean Code konularında öğrenme / uygulama projesi.

---

## ⭐ Amaç

Bu proje bir "production-ready enterprise application" iddiası taşımaz.

Amaç:

> **Spring Boot annotation'larını ezberlemek yerine, gerçek bir proje üzerinde neden kullanıldıklarını anlayarak öğrenmek.**
