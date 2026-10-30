import 'package:dotenv/dotenv.dart';
import 'package:supabase/supabase.dart';

SupabaseClient conectar() {
  final env = DotEnv()..load();
  final url = env['SUPABASE_URL'];
  final chave = env['SUPABASE_PUBLISHABLE_KEY'];

  if (url == null || url.isEmpty ||
      chave == null || chave.isEmpty) {
    throw StateError('Preencha a URL e a chave no arquivo .env.');
  }

  final supabase = SupabaseClient(url, chave);

  print('Cliente Supabase criado com sucesso!');

  return supabase;
}