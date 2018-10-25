Speed game

# Json Messages

## Client:

### Connect
```
{
	"type": "connect",
	"username": "username"
}
```

### Move
```
{
	"type": "move",
	"card": "3",
	"to": 0
}
```


## Server:

### Card
```
{
	"type": "card",
	"card": "3"
}
```

### Chat
```
{
	"type": "chat",
	"message": "message"
}
```

### Invalid
```
{
	"type": "invalid",
	"message": "message"
}
```

### MiddleCards, OpponentCards, PlayerCards
```
{
	"type": "playerCards",
	"cards": [
		"b",
		"4",
		"9",
		"b"
	]
}
```

### Start
```
{
	"type": "start",
	"player": "name"
}
```