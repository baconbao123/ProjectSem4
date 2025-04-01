import 'package:flutter/material.dart';

class LoginUserScreen extends StatefulWidget {
  const LoginUserScreen({super.key});

  @override
  _LoginUserScreenState createState() => _LoginUserScreenState();
}

class _LoginUserScreenState extends State<LoginUserScreen> {
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  void _login() {
    String email = _emailController.text.trim();
    String password = _passwordController.text;

    if (email.isEmpty || password.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text("Email or Password can't empty")),
      );
      return;
    }

    // Checked admin
    if (email == "sa@gmail.com" && password == "123") {
      Navigator.pushReplacementNamed(context, "/dashboard");
    } else {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text("Email or Password is incorrect")),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Center(
          child: Column(
            children: [
              // =========== Login Img ==============
              SizedBox(
                width: 400,
                height: 300,
                child: Ink.image(
                  image: const AssetImage("assets/images/logo.png"),
                ),
              ),

              // =========== Login Text ==============
              const Text(
                'LOGIN',
                style: TextStyle(
                  fontSize: 40,
                  fontWeight: FontWeight.bold,
                ),
              ),
              const SizedBox(height: 30),

              // ====== Email Input =======
              SizedBox(
                width: 340,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text("Email", style: TextStyle(fontSize: 20)),
                    const SizedBox(height: 10),
                    TextField(
                      // Enter email
                      controller: _emailController,
                      keyboardType: TextInputType.emailAddress,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.grey[700],
                        height: 2,
                      ),
                      decoration: InputDecoration(
                        hintText: "a@gmail.com",
                        filled: true,
                        fillColor: Colors.grey[300],
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(20),
                          borderSide: BorderSide.none,
                        ),
                        contentPadding: const EdgeInsets.all(12),
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 24),

              // ====== Password Input =======
              SizedBox(
                width: 340,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const Text("Password", style: TextStyle(fontSize: 20)),
                    const SizedBox(height: 10),
                    TextField(
                      // Enter password
                      controller: _passwordController,
                      obscureText: true,
                      style: TextStyle(
                        fontSize: 16,
                        color: Colors.grey[700],
                        height: 2,
                      ),
                      decoration: InputDecoration(
                        filled: true,
                        fillColor: Colors.grey[300],
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(20),
                          borderSide: BorderSide.none,
                        ),
                        contentPadding: const EdgeInsets.all(12),
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 36),

              // ============== Login Button ==============
              SizedBox(
                width: 340,
                height: 60,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: Colors.blue[200],
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(20),
                    ),
                  ),
                  onPressed: _login,
                  child: const Text(
                    "Login",
                    style: TextStyle(
                      fontSize: 24,
                      fontWeight: FontWeight.bold,
                      color: Colors.white,
                    ),
                  ),
                ),
              ),
              const SizedBox(height: 30),

              // ============== Login With ==============
              SizedBox(
                width: 220,
                child: Row(
                  children: [
                    const Text("Login with", style: TextStyle(fontSize: 20)),
                    const SizedBox(width: 20),

                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceAround,
                      children: [
                        SizedBox(
                          child: Ink.image(
                            width: 36,
                            height: 36,
                            image: const AssetImage("assets/icons/google.png"),
                          ),
                        ),

                        const SizedBox(width: 10),

                        SizedBox(
                          child: Ink.image(
                            width: 36,
                            height: 36,
                            image: const AssetImage("assets/icons/fb.png"),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 16),

              // ============== Divider ==============
              SizedBox(
                width: 320,
                child: Divider(thickness: 2, color: Colors.grey[300]),
              ),
              const SizedBox(height: 16),

              // ============== Sign Up Link ==============
              SizedBox(
                width: 180,
                child: Row(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    const Text("No Account?", style: TextStyle(fontSize: 16)),
                    TextButton(
                      onPressed: () {
                        Navigator.pushNamed(context, "/signup");
                      },
                      child: Text(
                        "Sign up",
                        style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.blue[200]),
                      ),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
