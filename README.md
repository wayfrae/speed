Speed game

# Json Messages

## Cards:

### Normal
2-10, j, q, k , a

### Extra
b = back of card

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

For "to:"

0 = left pile<br/>
1 = right pile


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