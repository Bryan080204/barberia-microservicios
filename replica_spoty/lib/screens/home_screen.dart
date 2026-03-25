import 'package:flutter/material.dart';
import '../widgets/sidebar.dart';
import '../widgets/music_card.dart';
import '../widgets/artist_card.dart';
import '../widgets/section_title.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Color(0xFF121212),

      body: Row(
        children: [

          // 🔵 IZQUIERDA
          Sidebar(),

          // 🔵 DERECHA
          Expanded(
            child: Padding(
              padding: const EdgeInsets.all(16),

              child: ListView(
                children: [

                  SectionTitle(text: "Canciones del momento"),

                  SizedBox(height: 10),

                  SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    child: Row(
                      children: [
                        MusicCard(title: "SWIM"),
                        MusicCard(title: "Días Tristes"),
                        MusicCard(title: "San Charly"),
                      ],
                    ),
                  ),

                  SizedBox(height: 30),

                  SectionTitle(text: "Artistas populares"),

                  SizedBox(height: 10),

                  SingleChildScrollView(
                    scrollDirection: Axis.horizontal,
                    child: Row(
                      children: [
                        ArtistCard(name: "Bad Bunny"),
                        ArtistCard(name: "Peso Pluma"),
                        ArtistCard(name: "Feid"),
                      ],
                    ),
                  ),
                ],
              ),
            ),
          )
        ],
      ),
    );
  }
}