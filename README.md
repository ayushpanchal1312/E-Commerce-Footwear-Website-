# 👟 E-Commerce Footwear Website

## 📝 Overview  
- This project is a Java-based E-Commerce Website for managing footwear products, designed using the MVC (Model-View-Controller) architecture.
- It allows customers to browse and purchase footwear, while admins can manage products efficiently.
The main focus is on session management, user authentication, and role-based redirection.

## 🏗️ Architecture
**MVC Structure:**
- **Model:** Java classes representing data (Product, Cart, Order, Login).
- **View:** JSP pages for frontend (user and admin interfaces).
- **Controller:** Servlets handling all business logic and request processing.

## ⚙️ Technologies Used  
- **Backend:** Java, Servlet, JSP  
- **Frontend:** HTML, CSS, JSP  
- **Database:** MySQL  
- **Server:** Apache Tomcat

## 👥 Roles  

### 🔸 Admin  
- Add new products  
- View and manage existing products  
- Access dashboard after login  

### 🔸 Customer  
- Register/Login  
- Browse and add footwear to cart  
- View user info in navbar  
- Logout securely  
- Session maintained throughout the session  

## 🔐 Session Management Focus  
- Maintains session from **login to logout**  
- Tracks logged-in user data  
- Restricts access to pages without login  
- Redirects based on role (Admin → Dashboard, Customer → Home)  

## 🚀 Future Enhancements  
- 💳 Add **Payment Gateway** integration  
- 🎨 Enhance UI with modern design  
- 👟 Add more customer features (wishlist, order history)  
- 🧰 Add more admin tools (reports, analytics)

## 👨‍💻 Author  
### Ayush Panchal  
**MSc IT | Java Developer**  
- **linkdin:**https://www.linkedin.com/in/ayush-panchal-3a0b73276/

## 🗂️ How to Run  
1. Import the project into **Eclipse/IntelliJ**.  
2. Configure **Apache Tomcat** and **MySQL database**.  
3. Create the required tables and set connection in `ConnectionProvider.java`.  
4. Run the project on **localhost** and open in browser.  

⭐ **This project demonstrates core Servlet-JSP integration and session-based login with role management.**
