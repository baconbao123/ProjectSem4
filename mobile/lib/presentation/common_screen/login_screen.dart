import 'package:flutter/material.dart';
import 'package:mobileapp/core/theme/app_colors.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  _LoginScreenState createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
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
      Navigator.pushReplacementNamed(context, "/admin/dashboard");
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
              Container(
                margin: EdgeInsets.only(top: 30),
                child: SizedBox(
                  width: 400,
                  height: 290,
                  child: Ink.image(
                    image: const AssetImage("assets/images/logo.png"),
                  ),
                ),
              ),

              // =========== Login Text ==============
              Text(
                'LOGIN',
                style: TextStyle(
                  fontSize: 40,
                  fontWeight: FontWeight.bold,
                  color: AppColors.primary500Theme,
                ),
              ),
              // const SizedBox(height: 20),

              // ====== Email Input =======
              SizedBox(
                width: 340,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
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
                        hintText: "Email Address",
                        filled: true,
                        fillColor: Colors.white24,
                        enabledBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
                          borderSide: BorderSide(
                            color: AppColors.primary500Theme,
                            width: 1,
                          ),
                        ),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
                          borderSide: BorderSide(
                            color: AppColors.primary500Theme,
                            width: 1,
                          ),
                        ),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
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
                        hintText: "Password",
                        fillColor: Colors.white24,
                        enabledBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
                          borderSide: BorderSide(
                            color: AppColors.primary500Theme,
                            width: 1,
                          ),
                        ),
                        focusedBorder: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
                          borderSide: BorderSide(
                            color: AppColors.primary500Theme,
                            width: 1,
                          ),
                        ),
                        border: OutlineInputBorder(
                          borderRadius: BorderRadius.circular(8),
                        ),
                        contentPadding: const EdgeInsets.all(12),
                      ),
                    ),
                  ],
                ),
              ),
              const SizedBox(height: 4),

              Container(
                width: 340,
                alignment: Alignment.centerRight,
                child: SizedBox(
                  child: TextButton(
                    onPressed: () {},
                    child: Text(
                      "Forgotten Password?",
                      style: TextStyle(
                        fontSize: 16,
                        color: AppColors.primary500Theme,
                      ),
                    ),
                  ),
                ),
              ),

              const SizedBox(height: 8),

              // ============== Login Button ==============
              SizedBox(
                width: 340,
                height: 60,
                child: ElevatedButton(
                  style: ElevatedButton.styleFrom(
                    backgroundColor: AppColors.primary500Theme,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(8),
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
              const SizedBox(height: 12),

              // ============== Divider ==============
              SizedBox(
                width: 320,
                child: Divider(thickness: 2, color: Colors.grey[300]),
              ),
              const SizedBox(height: 8),

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
                        style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                          color: AppColors.primary500Theme,
                        ),
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
