import sys
from pydub import AudioSegment

if len(sys.argv) != 2:
    print("Usage: python audio_cutter.py <audio_file_path>")
    sys.exit(1)

audio_file_path = sys.argv[1]

audio_file = AudioSegment.from_file(audio_file_path)
audio_file_first_30s = audio_file[:30000]
output_file_path = audio_file_path[:-4] + "_first_30s.mp3"  # Add "_first_30s" to the output file name
audio_file_first_30s.export(output_file_path, format="mp3")
print(f"Saved first 30 seconds of {audio_file_path} to {output_file_path}")

