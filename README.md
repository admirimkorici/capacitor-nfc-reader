# nfcreader

NFC Reader Plugin for Ionic Capacitor app

## Install

```bash
npm install nfcreader
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`ReadNFCTag(...)`](#readnfctag)
* [`WriteNFCTag(...)`](#writenfctag)
* [`startNfcReading(...)`](#startnfcreading)
* [`stopNfcReading(...)`](#stopnfcreading)
* [`setNfcDataCallback(...)`](#setnfcdatacallback)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### ReadNFCTag(...)

```typescript
ReadNFCTag(options: { msg: string; }) => Promise<{ value: string; }>
```

| Param         | Type                          |
| ------------- | ----------------------------- |
| **`options`** | <code>{ msg: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### WriteNFCTag(...)

```typescript
WriteNFCTag(number: number) => Promise<{ value: number; }>
```

| Param        | Type                |
| ------------ | ------------------- |
| **`number`** | <code>number</code> |

**Returns:** <code>Promise&lt;{ value: number; }&gt;</code>

--------------------


### startNfcReading(...)

```typescript
startNfcReading(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### stopNfcReading(...)

```typescript
stopNfcReading(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------


### setNfcDataCallback(...)

```typescript
setNfcDataCallback(data: any) => Promise<any>
```

| Param      | Type             |
| ---------- | ---------------- |
| **`data`** | <code>any</code> |

**Returns:** <code>Promise&lt;any&gt;</code>

--------------------

</docgen-api>
