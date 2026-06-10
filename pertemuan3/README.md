# PRAKTIKUM PEMROGRAMAN TEKNOLOGI MOBILE 
## PERTEMUAN 3  
 
 
 ### TUGAS 1 : PROGRAM PERTAMA KOTLIN
 
    fun main() {
        println("1")
        println("2")
        println("3")
    }

    //outputnya adalah
    //1
    //2
    //3

### Buat Output 
I'm
Learning
Kotlin!

    fun main () {
        println("I'm")
        println("Learning")
        println("Kotlin!")
    }

### Perbaiki hinggan program mencetak output
Monday
Tuesday
Wednesday
Thursday
Friday

    fun main() {
    println("Monday")
    println("Tuesday")
    println("Thursday")
    println("Wednesday")
    println("Friday")
}

### Perbaiki error (kurang tanda "}" pada akhir program)
    fun main() {
        println("Tomorrow is rainy")
    }
 
### Perbaiki error (Penulisan printLine seharusnya println)
    fun main() {
        println("There is a chance of snow")
    }

### Perbaiki error (Enter setiap kode)
    fun main() {
        println("Cloudy") 
        println("Partly Cloudy") 
        println("Windy")
    }

### Perbaiki error (Tanda "()" Seharusnya "{}" )
    fun main() {
        println("How's the weather today?")
    }


 ## TUGAS 2 : MEMBUAT DAN MENGGUNAKAN VARIABEL
### Template String
    fun main() {
    val count: Int = 10
    println("You have $count unread messages.")
    }

### Operasi matematika dasar
    fun main() {
        val unreadCount = 5
        val readCount = 100
        println("You have ${unreadCount + readCount} total messages in your inbox.")
    }

Outputnya : You have 105 total messages in your inbox.

    fun main() {
        val numberOfPhotos = 100
        val photosDeleted = 10
        println("$numberOfPhotos photos")
        println("$photosDeleted photos deleted")
        println("${numberOfPhotos - photosDeleted} photos left")
    }

Outputnya : 100 photos
10 photos deleted
90 photos left

### Memperbaharui variable
    fun main() {
        val cartTotal = 0 // val diganti dengan var 
        cartTotal = 20
        println("Total: $cartTotal")
    }

### Operator penambahan dan pengurangan
    fun main() {
        var count = 10
        println("You have $count unread messages.")
        count = count + 1
        println("You have $count unread messages.")
    }

Disederhanakan menjadi count++ atau jika pengurangan menjadi count--

    fun main() {
        var count = 10
        println("You have $count unread messages.")
        count++
        println("You have $count unread messages.")
    }

    fun main() {
        var count = 10
        println("You have $count unread messages.")
        count--
        println("You have $count unread messages.")
    }


### Mempelajari jenis data lainnya
    fun main() {
        val trip1: Double = 3.20
        val trip2: Double = 4.10
        val trip3: Double = 1.72
        val totalTripLength: Double = 0.0
        println("$totalTripLength miles left to destination")
    }

Outputnya : 0.0 miles left to destination

Perbaiki kode variable totalTripLenght 

    fun main() {
        val trip1: Double = 3.20
        val trip2: Double = 4.10
        val trip3: Double = 1.72
        val totalTripLength: Double = trip1 + trip2 + trip3
        println("$totalTripLength miles left to destination")
    }

Outputnya : 9.02 miles left to destination

Menghapus Double yang tidak perlu dideklarasi karena inferensi jenis

    fun main() {
        val trip1 = 3.20
        val trip2 = 4.10
        val trip3 = 1.72
        val totalTripLength = trip1 + trip2 + trip3
        println("$totalTripLength miles left to destination")
    }

### String
    fun main() {
        val nextMeeting = "Next meeting:"
        val date = "January 1"
        val reminder = nextMeeting + date
        println(reminder)
    }

Outputnya : Next meeting:January 1

Perbaharui variable nextMeeting dengan menambahkan spasi setelang titik 2(:)

    fun main() {
        val nextMeeting = "Next meeting: "
        val date = "January 1"
        val reminder = nextMeeting + date 
        println(reminder)
    }

Menambahkan literal string at work 

    fun main() {
        val nextMeeting = "Next meeting: "
        val date = "January 1"
        val reminder = nextMeeting + date + " at work"
        println(reminder)
    }

### Boolean
    fun main() {
        val notificationsEnabled: Boolean = true
        println(notificationsEnabled)
    }

Outputnya : true

Ubah nilai awal boolean menjadi false 

    fun main() {
        val notificationsEnabled: Boolean = false
        println(notificationsEnabled)
    }

Outputnya : false

    fun main() {
        val notificationsEnabled: Boolean = false
        println("Are notifications enabled? " + notificationsEnabled)
    }

Outputnya : Are notifications enabled? false

## TUGAS 3 : MEMBUAT DAN MENGGUNAKAN FUNGSI
### Menentukan dan memanggil fungsi
    fun main() {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

Tentukan fungsi baru bernama birtdayGreeting()

    fun main() {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

    fun birthdayGreeting() {
        
    }

Pindahkan dua pernyataan println() dari main() ke dalam tanda kurung kurawal fungsi birthdayGreeting()

    fun main() {
        
    }

    fun birthdayGreeting() {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

Di fungsi main(), panggil fungsi birthdayGreeting()

    fun main() {
        birthdayGreeting()
    }

    fun birthdayGreeting() {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

### Menampilkan nilai dari fungsi
    fun main() {
        birthdayGreeting()
    }

    fun birthdayGreeting(): Unit {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

Ganti Unit dengan String

    fun birthdayGreeting(): String {
        println("Happy Birthday, Rover!")
        println("You are now 5 years old!")
    }

Maka akan error : A 'return' expression required in a function with a block body ('{...}')

Ganti pernyataan println dengan variable nameGreeting, ageGreeting menggunakan val, tambahkan pernyataan return

    fun birthdayGreeting(): String {
    val nameGreeting = "Happy Birthday, Rover!"
    val ageGreeting = "You are now 5 years old!"
    return "$nameGreeting\n$ageGreeting"
}

    fun main() {
        println(birthdayGreeting())
    }
    fun birthdayGreeting(): String {
        val nameGreeting = "Happy Birthday, Rover!"
        val ageGreeting = "You are now 5 years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Outputnya : Happy Birthday, Rover!
You are now 5 years old!

### Menambahkan parameter ke fungsi birthdayGreeting()
Menambahkan parameter name ke String 

    fun birthdayGreeting(name: String): String {
        val nameGreeting = "Happy Birthday, Rover!"
        val ageGreeting = "You are now 5 years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Ganti Rover menjadi $name
    fun birthdayGreeting(name: String): String {
        val nameGreeting = "Happy Birthday, $name!"
        val ageGreeting = "You are now 5 years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Outputnya : No value passed for parameter 'name'.

Panggil di main

    fun main() {
        println(birthdayGreeting("Rover"))
    }

    fun birthdayGreeting(name: String): String {
        val nameGreeting = "Happy Birthday, $name!"
        val ageGreeting = "You are now 5 years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Sehingga Outputnya : Happy Birthday, Rover!
You are now 5 years old!

Tambahkan panggilan lain ke birthdayGreeting() didalam panggilan println()

    fun main() {
        println(birthdayGreeting("Rover"))
        println(birthdayGreeting("Rex"))
    }
    fun birthdayGreeting(name: String): String {
        val nameGreeting = "Happy Birthday, $name!"
        val ageGreeting = "You are now 5 years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Sehingga Outputnya : Happy Birthday, Rover!
You are now 5 years old!
Happy Birthday, Rex!
You are now 5 years old!

### Fungsi dengan beberapa parameter 
Deklarasi fungsi baru harus memiliki 2 parameter name dan age 

    fun birthdayGreeting(name: String, age: Int): String {
        val nameGreeting = "Happy Birthday, $name!"
        val ageGreeting = "You are now 5 years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Perbaharui fungsi birthdayGreeting() untuk menggunakan nilai age 

    fun birthdayGreeting(name: String, age: Int): String {
        val nameGreeting = "Happy Birthday, $name!"
        val ageGreeting = "You are now $age years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Ubah kedua panggilan menjadi fungsi birthdayGreeting() di main()

    fun main() {
        println(birthdayGreeting("Rover", 5))
        println(birthdayGreeting("Rex", 2))
    }

    fun birthdayGreeting(name: String, age: Int): String {
        val nameGreeting = "Happy Birthday, $name!"
        val ageGreeting = "You are now $age years old!"
        return "$nameGreeting\n$ageGreeting"
    }

Outputnya : Happy Birthday, Rover!
You are now 5 years old!
Happy Birthday, Rex!
You are now 2 years old!

## TUGAS 4 : SOAL LATIHAN DASAR-DASAR KOTLIN
### Memperbaiki error
    fun main() { 
        println("New chat message from a friend'}
    }
Typo tanda kurung yang seharusnya menjadi
 
    fun main() { 
            println{"New chat message from a friend'}
        }

### Template String
    fun main() {
        val discountPercentage: Int = 0
        val offer: String = ""
        val item = "Google Chromecast"
        discountPercentage = 20
        offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
        
        println(offer)
    }

val diganti dengan var sehingga 

    fun main() {
        var discountPercentage: Int = 0
        var offer: String = ""
        var item = "Google Chromecast"
        discountPercentage = 20
        offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
        
        println(offer)
    }

Outputnya : Sale - Up to 20% discount on Google Chromecast! Hurry up!

### Penyambungan String
    fun main() {
        val numberOfAdults = "20"
        val numberOfKids = "30"
        val total = numberOfAdults + numberOfKids
        println("The total party size is: $total")
    }

Menghapus tanda petik ("") pada variable numberOfAdults dab numberOfKids sehingga

    fun main() {
        val numberOfAdults = 20
        val numberOfKids = 30
        val total = numberOfAdults + numberOfKids
        println("The total party size is: $total")
    }

Outputnya : The total party size is: 50

### Pemformatan pesan
    fun main() {
        val baseSalary = 5000
        val bonusAmount = 1000
        val totalSalary = "$baseSalary + $bonusAmount"
        println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
    }
 
 Saya kira outputnya akan Congratulations for your bonus! You will receive a total of 6000 (additional bonus).

 ### Mengimplementasi operasi matematika dasar
 ### Langkah 1
    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        
        println("$firstNumber + $secondNumber = $result")
    }

Menambahkan val result = firstNumber + secondNumber sehingga menjadi

    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        val result = firstNumber + secondNumber
        println("$firstNumber + $secondNumber = $result")
    }
Outputnya : 10 + 5 = 15

### Langkah 2
    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        val thirdNumber = 8
        
        val result = add(firstNumber, secondNumber)
        val anotherResult = add(firstNumber, thirdNumber)

        println("$firstNumber + $secondNumber = $result")
        println("$firstNumber + $thirdNumber = $anotherResult")
    }

tambahkan fungsi add()

    fun main() {
        val firstNumber = 10
        val secondNumber = 5
        val thirdNumber = 8
        
        val result = add(firstNumber, secondNumber)
        val anotherResult = add(firstNumber, thirdNumber)

        println("$firstNumber + $secondNumber = $result")
        println("$firstNumber + $thirdNumber = $anotherResult")
    }

    // Define add() function below this line
    fun add(angka1: Int, angka2: Int): Int{
        val total = angka1 + angka2
        return total
    }

Outputnya : 10 + 5 = 15
10 + 8 = 18

### Langkah 3
belum bisa

### Parameter default
### Langkah 1
    fun main() {
        val operatingSystem = "Chrome OS"
        val emailId = "sample@gmail.com"

        println(displayAlertMessage(operatingSystem, emailId))
    }

Tambahkan 

    fun displayAlertMessage(operatingSystem: String, emailId: String): String {
        val pesan = "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
        return pesan
    }

Outputnya : There's a new sign-in request on Chrome OS for your Google Account sample@gmail.com.

### Langkah 2
    fun main() {
        val firstUserEmailId = "user_one@gmail.com"
        
        println(displayAlertMessage(emailId = firstUserEmailId))
        println()

        val secondUserOperatingSystem = "Windows"
        val secondUserEmailId = "user_two@gmail.com"

        println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
        println()

        val thirdUserOperatingSystem = "Mac OS"
        val thirdUserEmailId = "user_three@gmail.com"

        println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
        println()
    }

    fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String): String {
        val pesan = "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
        return pesan
    }

### Pedometer
    fun main() {
        val Steps = 4000
        val caloriesBurned = PEDOMETERstepsTOcalories(Steps);
        println("Walking $Steps steps burns $caloriesBurned calories") 
    }

    fun PEDOMETERstepsTOcalories(NumberOFStepS: Int): Double {
        val CaloriesBURNEDforEachStep = 0.04
        val TotalCALORIESburned = NumberOFStepS * CaloriesBURNEDforEachStep
        return TotalCALORIESburned
    }

Mengganti nama fungsi, parameter fungsi, dan variabel

    fun main() {
        val steps = 4000
        val caloriesBurned = calculateCalories(steps)
        println("Walking $steps steps burns $caloriesBurned calories") 
    }

    fun calculateCalories(numberOfSteps: Int): Double {
        val caloriesBurnedPerStep = 0.04
        val totalCaloriesBurned = numberOfSteps * caloriesBurnedPerStep
        return totalCaloriesBurned
    }

### Membandingkan 2 angka
    fun main() {
        // Menguji fungsi sesuai dengan 3 contoh dari soal
        println(bandingkanWaktu(timeSpentToday = 300, timeSpentYesterday = 250)) 
        println(bandingkanWaktu(timeSpentToday = 300, timeSpentYesterday = 300)) 
        println(bandingkanWaktu(timeSpentToday = 200, timeSpentYesterday = 220)) 
    }

    // Fungsi dengan dua parameter Int dan mengembalikan nilai Boolean
    fun bandingkanWaktu(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
        // Simbol > akan otomatis mengevaluasi angka dan menghasilkan true atau false
        return timeSpentToday > timeSpentYesterday
    }

Output : true
false
false

### Memidahkan kode duplikat ke fungsi
    fun main() {
        println("City: Ankara")
        println("Low temperature: 27, High temperature: 31")
        println("Chance of rain: 82%")
        println()

        println("City: Tokyo")
        println("Low temperature: 32, High temperature: 36")
        println("Chance of rain: 10%")
        println()
        
        println("City: Cape Town")
        println("Low temperature: 59, High temperature: 64")
        println("Chance of rain: 2%")
        println()
        
        println("City: Guatemala City")
        println("Low temperature: 50, High temperature: 55")
        println("Chance of rain: 7%")
        println()
    }

Sehingga menjadi 

    fun main() {
        // Memanggil fungsi cetakan dengan data yang berbeda-beda
        tampilkanCuaca(namaKota = "Ankara", suhuRendah = 27, suhuTinggi = 31, peluangHujan = 82)
        tampilkanCuaca(namaKota = "Tokyo", suhuRendah = 32, suhuTinggi = 36, peluangHujan = 10)
        tampilkanCuaca(namaKota = "Cape Town", suhuRendah = 59, suhuTinggi = 64, peluangHujan = 2)
        tampilkanCuaca(namaKota = "Guatemala City", suhuRendah = 50, suhuTinggi = 55, peluangHujan = 7)
    }

    // Membuat fungsi cetakan (tampilkanCuaca)
    fun tampilkanCuaca(namaKota: String, suhuRendah: Int, suhuTinggi: Int, peluangHujan: Int) {
        // Memasukkan parameter ke dalam kalimat menggunakan simbol $
        println("City: $namaKota")
        println("Low temperature: $suhuRendah, High temperature: $suhuTinggi")
        println("Chance of rain: $peluangHujan%")
        println() // Mencetak enter/baris kosong pemisah antar kota
    }


