import sys
import json
import pyperclip

file_path = 'clipboardMult.json'


def save_items(filepath, items):
    with open(filepath, 'w') as f:
        json.dump(items, f)


def load_items(filepath):
    try:
        with open(filepath, 'r') as f:
            data = json.load(f)
            return data
    except:
        return {}


if len(sys.argv) == 2:
    command = sys.argv[1]
    data = load_items(file_path)

    if command == 'save':
        key = input("Please enter a key to save under: ")
        data[key] = pyperclip.paste()
        save_items(file_path, data)

    elif command == 'load':
        key = input("Please enter a key to load: ")
        if key in data:
            pyperclip.copy(data[key])
            print('Text copied to clipboard...')
        else:
            print('key does not exist')
    elif command == 'list':
        print(data)
    else:
        print("unknown command")
else:
    print("please pass one command")