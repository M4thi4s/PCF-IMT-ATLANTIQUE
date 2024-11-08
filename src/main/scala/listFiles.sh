find . -type f -name "*.scala" | while IFS= read -r file; do
  echo "$file"
  echo
  cat "$file"
  echo
done

