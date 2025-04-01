import 'package:flutter/material.dart';
import 'package:mobileapp/presentation/admin/screens/dashboard_screen.dart';
import 'package:mobileapp/presentation/common_screen/login_screen.dart';
import 'package:mobileapp/presentation/common_screen/not_found.dart';
class AppRoutes {
  // common_screen
  static const String login = "/login";

  // ================= Admin =====================
  static const String dashboard = "/admin/dashboard";

  static Route<dynamic> generateRoute(RouteSettings settings) {
    switch (settings.name) {
      case login:
        return MaterialPageRoute(builder: (_) => LoginScreen());
      case dashboard:
        return MaterialPageRoute(builder: (_) => DashboardScreen());
      default:
        return MaterialPageRoute(builder: (_) => NotFound());
    }
  }
}
