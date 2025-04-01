import 'package:flutter/material.dart';

class NotFound extends StatelessWidget {
  const NotFound({super.key});

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        body: Center(
          child: Ink(
            child: Ink.image(image: AssetImage("assets/images/not_found.png")),
          ),
        ),
      ),
    );
  }
}
