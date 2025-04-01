import 'package:flutter/material.dart';
import 'package:mobileapp/core/theme/app_colors.dart';

class DashboardScreen extends StatelessWidget {
  const DashboardScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(
          toolbarHeight: 70,
          automaticallyImplyLeading: false,
          title: Row(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisSize: MainAxisSize.max,
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              // =========== Btn Menu ==========
              IconButton(
                onPressed: () {},
                icon: Icon(Icons.menu_outlined, size: 40),
                style: IconButton.styleFrom(
                  foregroundColor: AppColors.primary500Theme,
                ),
              ),

              // =========== Logo ==========
              Image.asset("assets/images/logo.png", height: 70, width: 120),

              // =========== Avatar ==========
              CircleAvatar(
                backgroundImage: AssetImage("assets/images/logo.png"),
                radius: 20,
              ),
            ],
          ),
        ),
        // Body
        body: Center(child: Text("This is dashboard")),
      ),
    );
  }
}
