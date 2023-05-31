# Tugas 2 -- Pembuatan API untuk Aplikasi E-Commerce Sederhana

**Nama  : Ni Putu Putri Maheswari Paramhansa**

**NIM   : 2205551101**

**Matkul: Pemrograman Berorientasi Objek** 

Project ini dibuat dalam rangka pemenuhan tugas kedua berupa pembuatan API untuk aplikasi e-commerce secara sederhana, di mana pembuatan API sendiri difungsikan dalam mengakses dan memanipulasi data setiap entitas dari database

# API-Key Authorization

```
    public static Boolean apiAuthorization(HttpExchange exchange) throws FileNotFoundException{
        Headers requestHeaders = exchange.getRequestHeaders();
        String headersKey = "Api-key:"+requestHeaders.getFirst("Api-key");
        File file = new File(".env");
        String api_key = null;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("Api-key")) {
                api_key = line;
            } else{
                api_key = "NULL";
            }
        }
        scanner.close();
        if(headersKey.equals(api_key)){
            return true;
        }
        return false;
    }
```

# Daftar Seluruh User

Untuk dapat memperoleh seluruh list user, kita perlu mengirimkan url berupa http:localhost:8101/users dengan request method GET seperti yang terlihat di bawah ini

```
{
    "User Information": [
        {
            "First_Name": "Lashira",
            "Id_User": 1,
            "Type": "seller",
            "Email": "lashiradini@email.com",
            "Last_Name": "Dini",
            "Phone_Number": "62812345678"
        },
        {
            "First_Name": "Dira",
            "Id_User": 2,
            "Type": "seller",
            "Email": "diranindita@email.com",
            "Last_Name": "Anindita",
            "Phone_Number": "62822783455"
        },
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Type": "buyer",
            "Email": "sintapurnama@email.com",
            "Last_Name": "Purnama",
            "Phone_Number": "62879612321"
        },
        {
            "First_Name": "Fajar",
            "Id_User": 4,
            "Type": "buyer",
            "Email": "fajarwibowo3@email.com",
            "Last_Name": "Wibowo",
            "Phone_Number": "62818903457"
        },
        {
            "First_Name": "Indi",
            "Id_User": 5,
            "Type": "seller",
            "Email": "indiee@email.com",
            "Last_Name": "Putra",
            "Phone_Number": "62876856082"
        },
        {
            "First_Name": "Fania",
            "Id_User": 6,
            "Type": "seller",
            "Email": "faniaratuu4@email.com",
            "Last_Name": "Ratu",
            "Phone_Number": "62866740923"
        },
        {
            "First_Name": "Rania",
            "Id_User": 7,
            "Type": "buyer",
            "Email": "raniaaput6@email.com",
            "Last_Name": "Putri",
            "Phone_Number": "62877890346"
        },
        {
            "First_Name": "Risa",
            "Id_User": 8,
            "Type": "buyer",
            "Email": "risaanjan7@email.com",
            "Last_Name": "Anjani",
            "Phone_Number": "62899576238"
        },
        {
            "First_Name": "Sheilla",
            "Id_User": 9,
            "Type": "seller",
            "Email": "sheillaatan8@email.com",
            "Last_Name": "Tania",
            "Phone_Number": "62877653480"
        },
        {
            "First_Name": "Vina",
            "Id_User": 10,
            "Type": "seller",
            "Email": "vinadanuarta03@email.com",
            "Last_Name": "Danuarta",
            "Phone_Number": "62864577979"
        }
    ]
}
```

# Informasi User dengan Id Tertentu

Untuk dapat memperoleh detail informasi user berdasarkan id user tertentu, maka kita perlu mengirimkan url berupa http:localhost:8101/users/3 seperti yang terlihat di bawah ini

```
{
    "User Information": [
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Type": "buyer",
            "Email": "sintapurnama@email.com",
            "Last_Name": "Purnama",
            "Phone_Number": "62879612321"
        }
    ]
}
```

# Daftar Produk dengan Id Tertentu
Untuk dapat memperoleh detail produk yang dimiliki user berdasarkan id tertentu, maka kita perlu mengirimkan url berupa http:localhost:8101/users/5/products seperti yang terlihat di bawah ini.
```
{
    "User Information": [
        {
            "First_Name": "Indi",
            "Id_User": 5,
            "Description": "Celana jeans wanita dengan model skinny fit dan tampilan modis.",
            "Last_Name": "Putra",
            "Price": 180000,
            "Title": "Celana Jeans Wanita",
            "Stock": 25
        }
    ]
}
```

# Daftar Order dengan Id Tertentu

Untuk dapat memperoleh list order yang dimiliki user berdasarkan id tertentu, maka kita perlu mengirimkan url berupa http:localhost:8101/users/4/orders seperti yang terlihat di bawah ini.

```
{
    "User Information": [
        {
            "First_Name": "Fajar",
            "Id_User": 4,
            "Last_Name": "Wibowo",
            "Price": "228000",
            "Note": "44444",
            "Title": "Dompet Kulit Wanita",
            "Quantity": "2"
        },
        {
            "First_Name": "Fajar",
            "Id_User": 4,
            "Last_Name": "Wibowo",
            "Price": "228000",
            "Note": "99999",
            "Title": "Dompet Kulit Wanita",
            "Quantity": "2"
        }
    ]
}
```

# Daftar Review User Tertentu

Untuk dapat memperoleh detail review yang dibuat oleh user berdasarkan id tertentu, maka kita perlu mengirimkan url berupa http:localhost:8101/users/3/reviews seperti yang terlihat di bawah ini

```
{
    "User Information": [
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Description": "Walaupun harga sedikit mahal, produk ini cukup memuaskan.",
            "Last_Name": "Purnama",
            "Star": "3"
        },
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Description": "Walaupun harga sedikit mahal, produk ini cukup memuaskan.",
            "Last_Name": "Purnama",
            "Star": "3"
        },
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Description": "Kualitas produknya sangat baik dan tahan lama. Terbuat dari bahan yang berkualitas.",
            "Last_Name": "Purnama",
            "Star": "4"
        },
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Description": "Kualitas produknya sangat baik dan tahan lama. Terbuat dari bahan yang berkualitas.",
            "Last_Name": "Purnama",
            "Star": "4"
        },
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Description": "Meskipun ada sedikit cacat pada produk, tetapi masih dapat diterima.",
            "Last_Name": "Purnama",
            "Star": "3"
        },
        {
            "First_Name": "Sinta",
            "Id_User": 3,
            "Description": "Meskipun ada sedikit cacat pada produk, tetapi masih dapat diterima.",
            "Last_Name": "Purnama",
            "Star": "3"
        }
    ]
}
```

# Daftar Informasi Order

Untuk dapat memperoleh detail informasi order yang dimiliki user berdasarkan id tertentu, maka kita perlu mengirimkan url berupa http:localhost:8101/users/7/orders seperti yang terlihat di bawah ini

```
{
    "User Information": [
        {
            "First_Name": "Rania",
            "Id_User": 7,
            "Last_Name": "Putri",
            "Price": "304000",
            "Note": "11111",
            "Title": "Jam Dinding Modern",
            "Quantity": "4"
        },
        {
            "First_Name": "Rania",
            "Id_User": 7,
            "Last_Name": "Putri",
            "Price": "304000",
            "Note": "11111",
            "Title": "Jam Dinding Modern",
            "Quantity": "4"
        },
        {
            "First_Name": "Rania",
            "Id_User": 7,
            "Last_Name": "Putri",
            "Price": "304000",
            "Note": "55555",
            "Title": "Jam Dinding Modern",
            "Quantity": "4"
        },
        {
            "First_Name": "Rania",
            "Id_User": 7,
            "Last_Name": "Putri",
            "Price": "304000",
            "Note": "77777",
            "Title": "Jam Dinding Modern",
            "Quantity": "4"
        }
    ]
}
```

# List Seluruh Produk

Untuk dapat memperoleh list seluruh produk beserta informasinya secara lengkap, maka kita perlu mengirimkan url berupa http:localhost:8101/products seperti yang terlihat di bawah ini

```
{
    "Product Information": [
        {
            "Id_User": 1,
            "Description": "Baju casual pria dengan desain modern dan nyaman untuk dipakai sehari-hari.",
            "Price": "150000",
            "Title": "Baju Casual Pria",
            "Id": 1,
            "Stock": 50
        },
        {
            "Id_User": 1,
            "Description": "Sepatu olahraga wanita dengan tampilan stylish dan nyaman saat digunakan.",
            "Price": "250000",
            "Title": "Sepatu Olahraga Wanita",
            "Id": 2,
            "Stock": 30
        },
        {
            "Id_User": 2,
            "Description": "Jam tangan unisex dengan desain elegan dan strap kulit berkualitas tinggi.",
            "Price": "350000",
            "Title": "Jam Tangan Unisex",
            "Id": 3,
            "Stock": 20
        },
        {
            "Id_User": 6,
            "Description": "Tas ransel anak dengan motif kartun lucu dan bahan tahan lama.",
            "Price": "100000",
            "Title": "Tas Ransel Anak",
            "Id": 4,
            "Stock": 40
        },
        {
            "Id_User": 6,
            "Description": "Kemeja formal pria dengan potongan slim fit dan bahan berkualitas tinggi.",
            "Price": "200000",
            "Title": "Kemeja Formal Pria",
            "Id": 5,
            "Stock": 15
        },
        {
            "Id_User": 5,
            "Description": "Celana jeans wanita dengan model skinny fit dan tampilan modis.",
            "Price": "180000",
            "Title": "Celana Jeans Wanita",
            "Id": 6,
            "Stock": 25
        },
        {
            "Id_User": 10,
            "Description": "Sepatu sneakers pria dengan desain sporty dan nyaman saat dipakai.",
            "Price": "300000",
            "Title": "Sepatu Sneakers Pria",
            "Id": 7,
            "Stock": 10
        },
        {
            "Id_User": 9,
            "Description": "Dompet kulit wanita dengan desain elegan dan banyak saku penyimpanan.",
            "Price": "120000",
            "Title": "Dompet Kulit Wanita",
            "Id": 8,
            "Stock": 35
        },
        {
            "Id_User": 10,
            "Description": "Jam dinding modern dengan tampilan minimalis dan mudah terbaca.",
            "Price": "80000",
            "Title": "Jam Dinding Modern",
            "Id": 9,
            "Stock": 60
        },
        {
            "Id_User": 6,
            "Description": "Kacamata sunglasses unisex dengan lensa UV protection dan frame kuat.",
            "Price": "220000",
            "Title": "Kacamata Sunglasses Unisex",
            "Id": 10,
            "Stock": 8
        },
        {
            "Id_User": 1,
            "Description": "Baju casual wanita dengan desain modern dan nyaman untuk dipakai sehari-hari.",
            "Price": "150000",
            "Title": "Baju Casual Wanita",
            "Id": 11,
            "Stock": 50
        }
    ]
}
```

# Daftar Produk yang Dijual Seller Tertentu
Untuk dapat memperoleh list produk yang dijual seller berdasarkan id tertentu, maka kita perlu mengirimkan url berupa http:localhost:8101/products/9 seperti yang terlihat di bawah ini

```
{
    "Product Information": [
        {
            "Id_User": 10,
            "Description": "Jam dinding modern dengan tampilan minimalis dan mudah terbaca.",
            "Price": "80000",
            "Title": "Jam Dinding Modern",
            "Id": 9,
            "Stock": 60
        }
    ]
}
```

# Filtering dengan Query Params

Untuk dapat melihat informasi seluruh user yang memiliki tipe seller maka dapat dengan mengirimkan request url http:localhost:8101/users?type="seller" seperti di bawah ini

```
{
    "User Information": [
        {
            "First_Name": "Lashira",
            "Id_User": 1,
            "Type": "seller",
            "Email": "lashiradini@email.com",
            "Last_Name": "Dini",
            "Phone_Number": "62812345678"
        },
        {
            "First_Name": "Dira",
            "Id_User": 2,
            "Type": "seller",
            "Email": "diranindita@email.com",
            "Last_Name": "Anindita",
            "Phone_Number": "62822783455"
        },
        {
            "First_Name": "Indi",
            "Id_User": 5,
            "Type": "seller",
            "Email": "indiee@email.com",
            "Last_Name": "Putra",
            "Phone_Number": "62876856082"
        },
        {
            "First_Name": "Fania",
            "Id_User": 6,
            "Type": "seller",
            "Email": "faniaratuu4@email.com",
            "Last_Name": "Ratu",
            "Phone_Number": "62866740923"
        },
        {
            "First_Name": "Sheilla",
            "Id_User": 9,
            "Type": "seller",
            "Email": "sheillaatan8@email.com",
            "Last_Name": "Tania",
            "Phone_Number": "62877653480"
        },
        {
            "First_Name": "Vina",
            "Id_User": 10,
            "Type": "seller",
            "Email": "vinadanuarta03@email.com",
            "Last_Name": "Danuarta",
            "Phone_Number": "62864577979"
        }
    ]
}
```

# Adding Data ke Server dengan Format JSON

Untuk melakukan penambahan data ke dalam server kita perlu mengirimkan url berupa http:localhost:8101/users dengan request method POST, selanjutnya kita  menginsert data dalam bentuk JSON seperti yang terlihat di bawah ini

```
{
    "First_Name": "Erika",
    "Type": "seller",
    "Email": "eritan44@email.com",
    "Last_Name": "Tania",
    "Phone_Number": "62864577990"
}
```

# Updating Data ke Server dengan Format JSON

Untuk melakukan penambahan data ke dalam server kita perlu mengirimkan url berupa http:localhost:8101/users/1 dengan request method PUT, selanjutnya kita menambahkan data sesuai yang kita inginkan dalam bentuk JSON seperti yang terlihat di bawah ini

```
{
    "First_Name": "Erika",
    "Type": "seller",
    "Email": "eritan44@email.com",
    "Last_Name": "Tania",
    "Phone_Number": "62864577990"
}

```

# Deleting Data dalam Server 

Untuk melakukan penghapusan data yang ada dalam server kita perlu mengirimkan url berupa http:localhost:8101/users/1 dengan request method DELETE

