# Vote App  - Spring Boot Project

*Application to manage an online voting site where users can register their personal data and allow
them to vote for candidates that belong to a specific committee.*


**Prerequisites:** 
   
 1. JDK 1.8 or later 
 2. Maven 3 or later 
 3. Database is made in MySQL

 

> This tutorial is for people with experience working with  Spring Boot Apps, Maven, Eclipse or Netbeans IDE.

**How to run on eclipse?**
## 1. Prepare the project
 - [ ] Clone or download ZIP
 - [ ] Import project into Eclipse
 - [ ] Install dependencies with Maven (From terminal: mvn install)
		 
	 1. Rigth click over project -> Maven -> Update Project...
	 2. Run the project: rigth click over project -> Run As -> Spring Boot App

 - [ ]  Run the script of the database from file database_vote_test.sql,   It's in main folder, the name database: vote_test
## 2. Config database conexion
 - [ ] Go to path: src/main/resources and configure file **"application.properties"**
 - [ ] You have to set  "user and password" 
 - [ ]  Change parameters base of your own details (replace "[values]") 
		      **spring.datasource.url = [URI database ]
				spring.datasource.username = [username]
				spring.datasource.password = [password]**

  
# 3.  Test App

> You may access to location server and port at: [http://localhost:8080/](http://localhost:8080/) 
 1. Sign up (It's very simple)
		*I recommend that you choose a country between El Salvador, Guatemala or Costa Rica.*
 2. Once you Sign in, you can vote for candidates that belong to a specific committee registered for your country.
 

## How to consume Web Services?

> I have implemented "Content Negociation" which means that you can get the response in JSON or XML format. (You have to send a header param - {"Accept": "application/xml"})

*If you prefer, you can use "Postman App"

1. **Get candidates registered**
	Type on your browser : [http://localhost:8080/getRegisteredCandidates](http://localhost:8080/getRegisteredCandidates)

2. **Get number of visitors per date**
	Type on your browser : [http://localhost:8080/getVisitorsReport](http://localhost:8080/getVisitorsReport)

## Integration need

A report with committee statistics in JSON format order by committee name is send by email to the administrators once a day (at 10 AM CST).


The implementation is located in path:  src/main/java/com/telus/testtelus/component/ScheduledTasks.java



## Any doub?

You can get in touch with me.  [https://www.jossuemejia.com](https://www.jossuemejia.com)


# 4.  Some screenshots

![Login](https://lh3.googleusercontent.com/xLA7eUvw8ueLTCdY_OQlRh9Av7syKoHgAwvbyBQE8VTAa6u9zztDLGtRjs-mQdzva3GhxwvXOO1TZyrMnc628aqGMb7OBqEMwPhaYhdrIAwMKILu05KOsQ1nva9CicBgot0vBYor4YX_Ms75CuJkLsdmOgDQqIRnQDNVY2YH37B6qo164wRmOodytgJSXIsgGwROac6PRW7AM4cvWMB7VzN24RKDbcuuogNo2axyNWpCsF-n_xvKRvBSNPJaczA8FOyDSPSfY2_B6P0nkzqhmi59SLmsvaNC-_XxlJvQ2AVP1lEFJUK-FjxkBzdNrj6xEFW89glUTMoLhyfVqSN2ZFw_YrocVWcjYpirJd_7XkHPPH3d4y_cMl4CMWZ50rCAQIVa3CtycAkCoq3vre45YxLFMvAfnMIoAI0u1wMPJoAfnO8985Yt37mlaqRhIJRceOuJ-Nb919M41tjQyxcQiKWyX6mkzX0E3-LZojrq6e413iJp6U35yPNBzYjMGBKjWYsFaBGaSdu74X4bu7pJySR05SRbl36p2pR8YJJ051h2Q_-WggeEy-rjuGj7e9l3t5habOKgFDYt4nmkRNEs9o4ayZhqvJvJjEXjZFTdcUsjKmZR-WYzx1GiSx0pInD2_CXVBn0ZhgCrYX3j05XhLOp09KJWWEogWxkvF54UH0ULSXxLXISXO1c=w1409-h779-no "login")


![SignUp](https://lh3.googleusercontent.com/ECMG1RVvrzJftBdAqaS4h2FV7VEdgnHVcoNX6CzHjI_HbThz5MYZ3-KSlvSgPw301kUz_1bsXx6Hdo5bvE-yo9x9VQffECzuJ2-rf787P-XRmXofEey780ena53n2-LC6POn9VsY1MmpbVez1A0gJN1GD5EKQYZY7gUotGJzu5Ff6FB97UDZnN09jeYCJ4CSKVtww3JoydFxN4IbWFJrAUEp_hjtaszBIQtz7SmwjXcOWrKOEUDDQqvnOygId9tyhK8opFqNVA4PQU6dB7IrNcWMFlSOkrR3Dd9oAfduOPRkK1vRgAtDeWlAhGlkr5qUnHJeb8GRTeBHluYyzBipokwbw0Tuv1uX_JID4zwgWXQrEH6Yw4rUg1EnE1WYXS0WCfN85YFWxQ0AN89VS1B2ug7KZijxoqB2fw3cG3f6VeWHntJvJIWUStx0j2mi62c9dblracwTDmhW0LbTzUhSSAB7XVoIKsA87Q95miq0coST775prjyU_G2xRUM3yLWqy19zQ70Vkf8iptKBbDaP0xbWfE2rmofhS14b2TKgcuNHLENzMJK6R9tvC54YC41i53YEz0BUryfh_yUplHQvfsZZdmX5K4P81EP27XgfTaiL1JtI8Kv-gpw-LrqnsOE_HleuY4gBrlwyLjjWdTdLml-Q9TXfDr5ArAVXDqkgeIDqiPtkxJ253do=w1406-h936-no "SignUp")


![List of committees](https://lh3.googleusercontent.com/8SoJHoziNOZ-K_js-sYW0YPixTdNtMI1esfzFVS-Eg_NLeLhuhbUPGOsoVV4sJfWYGZfFJ0g0v2-77IBriEWpjSQn8_yJxqJkE7KLYlZoLn4cY-GWvJluU-mG03Dz8id9NBmlIYrtADBhlR_HT6JhDaZJhKy_qo_qVt_nzT-molSUaJf0PAu9-imtYLJ7Xx-ItgAymtMUE7izkGgZMjot25IaubPhg8Zt9OO3jvFKT7G73n55qcQRUpDS5UHAU6kGPHhyFj39x9qlNfoKlBsTQ2UZ-alfxunZ_j_H7p7ARfahE1DZkyVQrbEYWNuFxy6jrsrPjFdaN_FQvLQpr8a7VpYnDcgZ3mE2LEmEyxmJFAtM9722CdgiKCDCimAFD59QVOf_hcnb0yayA88v_VsoJouI0IqGNwexr9Iw7Eir22kl435n1RfXQ6MFwJaSDANpvCZuPwjURTt6QmNeN8VjjdfyZqRnvDH9qSck2N7PZ91tN6pok54c8b7s82fvVAfeVYdQiLYuFXnU6pwK3nUlAtrT2MkVtduADOJkqrFXMI_45hZQgYUwStgL0MyyUr4gLq7wDAh1hD6x4pd_x_XcMH6sjnMnTxI_z_q8y5nNULu9tyY53yAF-jtJ0LJgXJctQLdF7MgZNO5R01PwxH4yZnWxKy0Ejf641rsN49I23ruzMB6bL7yEdA=w1403-h803-no "List of committees")


![Vote for a candidate](https://lh3.googleusercontent.com/TmpCmUiVKC0DkvFta9xRmQimKbHRLAFr79gtY0Hi-ffnTsSiS0uLsmY_HOSRf3NYZeESGqvHjazmLa5_e0uy0Fy78uHDSI7k1lza7TxYL9A9oKY90uXVPln2-XQIcJgXk8dQjpUMR03a2spTsUd1AU9ukwa3OcMqQ07WXH1sKrKXDBaWKE7weZcZ7Lm327wu5m01_7jhAFP739Zy3uLer8C3LQ4P8XQt0LRXhdbYXxdrg9JhkRl2MtJjmAo9xhLrC53X5ZmBk1amu2qjl4S5JdElzZDOkBu7cwl2982na7TnxbL9_VXjl7AOl3kRj6oLJmKcOhY366wj_KtbUHqvrZBNk-FW961z8SfXA2c9Hatf1rt2e73BqwKyvmT54W1_hG5R8B6o7Fs1u6daLN5EiotNbH51tFaMuiw67dCluIuk0hmUMW3RzzFP7M_InF5gs6V9JYg7u-Qd6jTK2qGgqKcvtHObiZKhv0D8OC0zjjGQMftxKPyoW_dfwq_ldGFjEBOXAiMw8xNja8JhLjZQu09fpvIdTX4AJSldmq2YR6abIxF017rQeK_42X2bmG7ihCXccH3Qi5IBZf6qj8QH-PtES7Uxp79sy6y5Foq507TGvIfbALIl7eQOYDGDrYxVIXPu-3Tx3hPPd-kJJMlDwBrv3NfPjx77xNO6zjGVI-fP2Q7MjPXtGRA=w1402-h888-no "Vote for a candidate")

