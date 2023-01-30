## /v1/userinfo

GET : 

Response Body

```json
[
    {
        "first_name": "Zen",
        "last_name": "Zhang"
    },
    {
        "first_name": "Zen",
        "last_name": "Li"
    }
]
```



POST:

Request Body

```json
{
    "provider":{
        "first_name":"Zen",
        "last_name":"Li",
        "dob":"2000-01-02"
    }
}
```

Response Body

```json
Create new user success. New user Id is : 2
```

